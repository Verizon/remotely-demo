package demo

import remotely._, codecs._
import scodec.{Codec,codecs => C}
import scodec.bits.BitVector

object protocol {

  type ActorId = String
  type MovieId = String

  case class Actor(id: ActorId, name: String, age: Option[Int] = None)
  case class Movie(id: MovieId, title: String, actors: List[ActorId])

  implicit val moviceCodec: Codec[Movie] =
    (utf8 ~~ utf8 ~~ list(utf8)).pxmap(Movie.apply _, Movie.unapply _)

  implicit val actorCodecs: Codec[Actor] =
    (utf8 ~~ utf8 ~~ optional(int32)).pxmap(Actor.apply _, Actor.unapply _)

  val definition = Protocol.empty
    .codec[Movie]
    .codec[Actor]
    .codec[List[Movie]]
    .specify0[List[Movie]]("listMovies")
    .specify1[List[ActorId], List[Actor]]("getActors")
}
