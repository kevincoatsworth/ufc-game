package services

import models.Fighter

class FighterService(){
  def getFighterInfo: List[Fighter] = List(Fighter("Conor McGregor", List("Khabib Nurmagomedov", "Eddie Alvarez", "Nate Diaz", "Nate Diaz")),
                                           Fighter("Donald Cerrone", List("Justin Gaethje", "Tony Ferguson", "Al Iaquinta", "Alexander Hernandez")),
                                           Fighter("Nate Diaz", List("Jorge Masvidal", "Anthony Pettis", "Conor McGregor", "Conor McGregor")),
                                           Fighter("Jorge Masvidal", List("Nate Diaz", "Ben Askren", "Darren Till", "Stephen Thompson")))
}
