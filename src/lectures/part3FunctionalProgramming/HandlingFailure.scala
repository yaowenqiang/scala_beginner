package lectures.part3FunctionalProgramming

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
    val aSuccess = Success(3)
    val aFailure = Failure(new RuntimeException("Super Failure"))
    println(aSuccess)
    println(aFailure)

    def unsafeMethod() : String = throw new RuntimeException("No STARING FOR YOU MONSTER")
    val potentialFailure = Try(unsafeMethod())
    println(potentialFailure)

    //syntax suger
    val anotherPotentialFailure = Try {

    }

    //utilities


    println(potentialFailure.isSuccess)

    // orelse
    def backupMethod() : String = "A valid result"
    val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
    println(fallbackTry)

    // if you design the API
    def betterUnsafeMethod() : Try[String] = Failure(new RuntimeException())
    def betterBackupMethod() : Try[String] =  Success("A Valid result")

    val betterFallback = betterUnsafeMethod() orElse(betterBackupMethod())

    // map, flatmap, filter

    println(aSuccess.map(_ * 2))
    println(aSuccess.flatMap(x => Success(x * 10)))
    println(aSuccess.filter(_ > 10))


    // for comprehension

    val hostName = "localhost"
    val port = "8080"
    def renderHtml(page: String) =  println(page)

    class Connection {
        def get(url: String): String = {
            val random = new Random(System.nanoTime())
            if (random.nextBoolean()) "<html>...</html>"
            else throw new RuntimeException("Connection interrupted")
        }
        def getSafe(url: String) :Try[String] = Try(get(url))
    }

    object HttpService {
        val random = new Random(System.nanoTime())
        def getConnection(host: String, port: String) :Connection = {
            if(random.nextBoolean()) new Connection
            else throw new RuntimeException("someone else took the port")
        }
        def getSafeConnection(host: String, port: String) :Try[Connection] = Try(getConnection(host, port))
    }


    val possibleConnection = HttpService.getSafeConnection(hostName, port)
    val possibleHtml = possibleConnection.flatMap(connection => connection.getSafe("/home"))
    possibleHtml.foreach(renderHtml)

    HttpService.getSafeConnection(hostName, port)
        .flatMap(connection => connection.getSafe("/home"))
        .foreach(renderHtml)


    for {
        connection <- HttpService.getSafeConnection(hostName, port)
        html <- connection.getSafe("/home")
    } renderHtml(html)


}
