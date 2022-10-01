package lectures.part2OOP

import playground.{PrinceCharming, Cinderella => Princess}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}


object PackagingAndImports extends App {
    // package members are accessible by their simple name
    val writer = new Writer("Jack", "rock the JVM", 22)
//    var princess = new Cinderella
    var princess = new Princess
// fully qualified name
//    var princess = new playground.Cinderella

    // packages are  in hierarchy
    // matching folder structure


    // package object
    sayHello
    println(SPEED_OF_LIGHT)


    val prince = new PrinceCharming

    val d = new Date()
//    val sqlDate = new sql.Date(2018, 1, 1)
    val sqlDate = new SqlDate(2018, 1, 1)

    // default imports
    // java.lang - String, Object, Exception
    // scala - Int, Nothing, Function
    // scala.Predef - println, ???


}
