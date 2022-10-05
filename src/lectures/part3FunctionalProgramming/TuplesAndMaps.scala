package lectures.part3FunctionalProgramming

object TuplesAndMaps extends App {
//    val aTuple = new Tuple2(1, "a string") // Tuple2[Int, String] = (Int, String)
    val aTuple = (1, "a string") // Tuple2[Int, String] = (Int, String)
    // a tuple can hva 22 data types
//    println(aTuple._1)
//    println(aTuple._2)
    val anotherTuple = aTuple.copy()
    println(aTuple._2 + " a combined string")
    println(aTuple.swap)

    // Maps
    val aMap : Map[String, Int] = Map()
//    val aPhoneBook = Map(("jack", 22), "John" -> 23)
    val aPhoneBook = Map(("jack", 22), "John" -> 23).withDefaultValue(-1)
    println(aPhoneBook)
    println(aPhoneBook.contains("jack"))
    println(aPhoneBook("jack"))
    println(aPhoneBook("marry"))
    val newMember = "Joy" -> 22
    val aNewPhoneBook = aPhoneBook + newMember
    println(aNewPhoneBook)

    //functions on Map
    println(aPhoneBook.map(pair => pair._1.toUpperCase->pair._2))
    // filter keys and values

    // TODO
    println(aPhoneBook.filterKeys(x => x.startsWith("J")))

    // Map Values


    // TODO
    println(aPhoneBook.mapValues(x => x + 10))

    // conversions
    println(aPhoneBook.toList)
    println(List(("John", 22)).toMap)
    val names = List("Joy", "Bob", "Jim", "Mary")
    println(names.groupBy(name => name.charAt(0)))











}
