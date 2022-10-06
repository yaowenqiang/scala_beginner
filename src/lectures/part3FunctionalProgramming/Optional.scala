package lectures.part3FunctionalProgramming

import scala.util.Random

object Optional extends App {
    val myFirstOption : Option[Int] = Some(1)
    val noOption : Option[Int] = None
    println(myFirstOption)
    println(noOption)

    //unsafe method

    def unsafeMethod() : String = null
//    val result = Some(unsafeMethod())
    val result  = Option(unsafeMethod())
    println(result)

    // chained Methods

    def backupMethod() :String = "A valid method"
    val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
    println(chainedResult)

    // DESIGN unsafe APIs

    def betterUnsafeMethod() :Option[String] = None
    def betterBackupMethod() :Option[String] = Some("A valid result")
    val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())

    println(myFirstOption.isEmpty)
    println(myFirstOption.get) // UNSAFE ,DO NOT USE THIS

    // map, flatMap, filter

    println(myFirstOption.map(_ + 2))
    println(myFirstOption.filter(x => x > 10))
    println(myFirstOption.flatMap(x => Option(x * 10)))


    val config: Map[String, String] = Map(
        "host" -> "192.168.0.1",
        "port" -> "80",
    )

    class Connection {
       def connect = "Connected"
    }

    object Connection {
        val random = new Random(System.nanoTime())
        def apply(host: String, port: String) :Option[Connection] =
            if(random.nextBoolean()) Some(new Connection())
            else None
    }

    val host = config.get("host")
    val port = config.get("port")
    // if (h != null)
//        if (p != null)
//            return connection.apply(h, p)
//        return null
    val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
//    if (c != null)
//        return c.connect
//    return null
    val connectionStatus = connection.map(c => c.connect)
    // if (connectionStatus == null) println(None) else print(Some(connectionStatus.get))
    println(connectionStatus)
    connectionStatus.foreach(println)

    // chained calls
    config.get("host")
        .flatMap(host => config.get("port")
        .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
        .foreach(println)

    // for comprehension

    val connectionStatus2 = for {
        host <- config.get("host")
        port <- config.get("port")
        connection <- Connection(host, port)
    } yield connection.connect

    println(connectionStatus2)

    connectionStatus2.foreach(println)








}
