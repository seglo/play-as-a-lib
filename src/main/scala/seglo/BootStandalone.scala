package seglo

import play.api.mvc.{Handler, RequestHeader}
import play.core.server._

object BootStandalone extends App {
  val pingRouter = new PingRouter(new PingController)
  val versionRouter = new VersionRouter(new VersionController)

  // in this mode you need to specify your own server config, although the fromRouter call will create a default instance
  val config = ServerConfig(
    port = Some(9000),
    address = "127.0.0.1"
  )
  // compose together routers, routes methods are partial functions, explore Router for more ways to filter routes
  // https://www.playframework.com/documentation/2.5.x/ScalaSirdRouter
  // https://www.playframework.com/documentation/2.5.x/ScalaEmbeddingPlay
  val routes: PartialFunction[RequestHeader, Handler] = pingRouter.routes.orElse(versionRouter.routes)

  val server = NettyServer.fromRouter(config)(routes)
}
