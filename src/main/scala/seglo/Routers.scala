package seglo

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

// Uses SIRD routing vs the routes file in the conf or resources dir
// https://www.playframework.com/documentation/2.5.x/ScalaSirdRouter#Binding-sird-Router
class PingRouter(controller: PingController) extends SimpleRouter {
  override def routes: Routes = {
    case GET(p"/ping") => controller.ping
  }
}

class VersionRouter(controller: VersionController) extends SimpleRouter {
  override def routes: Routes = {
    case GET(p"/version") => controller.version
  }
}
