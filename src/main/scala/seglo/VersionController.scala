package seglo

import play.api.mvc.{Action, Controller}

class VersionController extends Controller {

  def version() = Action {
    Ok(BuildInfo.toString)
  }
}
