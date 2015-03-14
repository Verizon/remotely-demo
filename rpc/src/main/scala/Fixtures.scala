package demo

import protocol._

object Fixtures {

  val actors = List(
    Actor(id = "a1", name = "Sienna Miller", Option(34)),
    Actor(id = "a2", name = "Bradley Cooper", Option(40)),
    Actor(id = "a3", name = "Cate Blanchett", Option(46)),
    Actor(id = "a4", name = "Lily James"),
    Actor(id = "a5", name = "Richard Madden", Option(28)),
    Actor(id = "a6", name = "Sharlto Copley", Option(42)),
    Actor(id = "a7", name = "Dev Patel", Option(25)))

  val movies = List(
    Movie(id = "m1", title = "American Sniper", List("a1","a2")),
    Movie(id = "m2", title = "Cinderella", List("a4","a3","a5")),
    Movie(id = "m3", title = "Chappie", List("a6","a7")))
}