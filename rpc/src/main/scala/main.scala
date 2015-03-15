package demo

import java.net.InetSocketAddress
import remotely._, codecs._, transport.netty._

object Server {

  def main(args: Array[String]): Unit = {
    val address = args.headOption.map(new InetSocketAddress(_,8080)
      ).getOrElse(sys.error("No IP address supplied as a main argument."))

    val service = new MovieServerImpl
    val env = service.environment
    val shutdown = env.serve(address,
      capabilities = Capabilities(Set.empty),
      monitoring = Monitoring.consoleLogger("[server]")).run
  }
}

object Client {
  import Remote.implicits._

  def main(args: Array[String]): Unit = {
    val address = new InetSocketAddress(args.head,8080) // totally unsafe!

    val exe = for {
      transport <- NettyTransport.single(address)
      endpoint   = Endpoint.single(transport)
      output    <- MovieClient.listMovies.runWithoutContext(endpoint)
      _         <- transport.shutdown
    } yield output

    println("Result from the server is: " + exe.run)

  }
}
