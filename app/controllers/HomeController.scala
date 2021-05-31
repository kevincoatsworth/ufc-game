package controllers

import models.Fighter

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

  def index() = {
    val fights = fighterInfo.getFighterInfo

    def randomNumber = nextInt(fights.size)

    lazy val fighter = fights(randomNumber)
    welcome(fights, fighter)
  }

  def welcome(fights: List[Fighter], fighter: Fighter) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome("friend", fights, fighter))
  }

  def onSubmit(fighterName: String) = Action { implicit request: Request[AnyContent] =>
    request.body.asFormUrlEncoded.get("person").head match {
      case name if name.equals(fighterName) => Ok(views.html.winner(fighterName))
      case _ => Ok(views.html.loser(fighterName))
    }
  }
}
