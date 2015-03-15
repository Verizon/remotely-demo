package demo

import remotely._
import protocol._

// NB: The GenServer macro needs to receive the FQN of all types, or import them
// explicitly. The target of the macro needs to be an abstract class.
@GenServer(demo.protocol.definition) abstract class MovieServer
@GenClient(demo.protocol.definition.signatures) object MovieClient

class MovieServerImpl extends MovieServer {
  object MovieNotFound extends RuntimeException

  def getActors: Movie => Response[List[Actor]] =
    mov => Response.now(Fixtures.actors.filter(a => mov.actors.contains(a.id)))

  def getMovie: MovieId => Response[Movie] =
    mid => Fixtures.movies.find(_.id == mid.toLowerCase)
      .map(Response.now).getOrElse(Response.fail(MovieNotFound))
}
