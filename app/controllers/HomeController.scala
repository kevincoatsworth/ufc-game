package controllers

import javax.inject._
import play.api.mvc._
import services.FighterService
import scala.util.Random._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val fighterInfo = new FighterService
  val fights = fighterInfo.getFighterInfo
  def randomNumber = nextInt(fights.size)
  lazy val fighter = fights(randomNumber)

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def welcome = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome("friend", fights, fighter))
  }

  def onSubmit() = Action { implicit request: Request[AnyContent] =>
    request.body.asFormUrlEncoded.get("person").head match {
      case fighter.name => Redirect(routes.HomeController.winner())
      case _  => Ok("Incorrect! Hit back to try again!")
    }
  }

  def winner() = Action { _ =>
    Ok(s"Well done! You correctly guessed that the previous opponents belonged to ${fighter.name}.")
  }

}
