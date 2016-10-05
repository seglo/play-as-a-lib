package seglo

import play.api.mvc.{Action, Controller}

class PingController extends Controller {

  def ping() = Action {
    Ok("Pong")
  }
}
