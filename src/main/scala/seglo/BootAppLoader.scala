package seglo

import com.typesafe.config.ConfigFactory
import play.api.ApplicationLoader.Context
import play.api.inject.{Injector, NewInstanceInjector, SimpleInjector}
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router
import play.api.{ApplicationLoader, _}

// For DI it would make more sense to use the GuiceApplicationLoader
// https://www.playframework.com/documentation/2.5.x/ScalaDependencyInjection#Advanced:-Extending-the-GuiceApplicationLoader
class BootAppLoader extends ApplicationLoader {

  override def load(context: Context): Application =
    new BuiltInComponentsFromContext(context) with AhcWSComponents {
      lazy val config = ConfigFactory.load()

      val pingRouter = new PingRouter(new PingController)
      val versionRouter = new VersionRouter(new VersionController)

      // compose together routers, routes methods are partial functions, explore Router for more ways to filter routes
      // https://www.playframework.com/documentation/2.5.x/ScalaSirdRouter
      // https://www.playframework.com/documentation/2.5.x/ScalaEmbeddingPlay
      override def router: Router = Router.from(pingRouter.routes.orElse(versionRouter.routes))

      //
      override lazy val injector: Injector = new SimpleInjector(NewInstanceInjector) + router + cookieSigner +
        csrfTokenSigner + httpConfiguration + tempFileCreator + global
    }.application
}


