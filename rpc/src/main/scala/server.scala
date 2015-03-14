package demo

import remotely._
import protocol._

// NB: The GenServer macro needs to receive the FQN of all types, or import them
// explicitly. The target of the macro needs to be an abstract class.
@GenServer(demo.protocol.definition)
abstract class MovieServer

class MovieServerImpl extends MovieServer {
  def getActors: List[ActorId] => Response[List[Actor]] = ids =>
    Response.now(Fixtures.actors.filter(a => ids.contains(a.id.toLowerCase)))

  def listMovies: Response[List[Movie]] =
    Response.now(Fixtures.movies)
}
