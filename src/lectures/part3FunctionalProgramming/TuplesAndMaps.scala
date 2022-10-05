package lectures.part3FunctionalProgramming

import scala.annotation.tailrec

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
    // bbe careful with mapping keys
    val aPhoneBook = Map(("jack", 21),("Jack", 22), "John" -> 23).withDefaultValue(-1)
    println(aPhoneBook)
    println(aPhoneBook.contains("jack"))
    println(aPhoneBook("jack"))
    println(aPhoneBook("marry"))
    val newMember = "Joy" -> 22
    val aNewPhoneBook = aPhoneBook + newMember
    println(aNewPhoneBook)

    //functions on Map
    println(aPhoneBook.map(pair => pair._1.toUpperCase->pair._2))
    println(aPhoneBook.map(pair => pair._1.toLowerCase->pair._2))
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


    // Exercises

    def add(network: Map[String,Set[String]], person: String) : Map[String, Set[String]] =
        network + (person -> Set())

    def friend(network: Map[String,Set[String]], a: String, b: String) : Map[String,Set[String]] = {
        val friendsOfA = network(a)
        val friendsOfB = network(b)
        network + (a -> (friendsOfA + b))  + (b -> (friendsOfB + a))
    }

    def unfriend(network: Map[String,Set[String]], a: String, b: String) : Map[String,Set[String]] = {
        val friendsOfA = network(a)
        val friendsOfB = network(b)
        network + (a -> (friendsOfA - b))  + (b -> (friendsOfB - a))
    }

    def remove(network: Map[String,Set[String]], person: String) : Map[String,Set[String]] = {
        @tailrec
        def removeAux(friends: Set[String],networkAcc:  Map[String,Set[String]]) : Map[String,Set[String]] =
            if (friends.isEmpty)  networkAcc
            else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

        val unfriends = removeAux(network(person), network)
        unfriends - person
    }

    val empty: Map[String, Set[String]] = Map()
    val network = add(add(empty, "Mary"), "Bob")
    println(network)
    println(friend(network, "Bob", "Mary"))
    println(unfriend(friend(network, "Bob", "Mary"), "Mary", "Bob"))
    println("before unfriend")
    println(friend(network, "Bob", "Mary"))
    println("after unfriend")
    println(remove(friend(network, "Bob", "Mary"), "Bob"))


    val people = add(add(add(empty, "Jim"),"Mary"),"Bob")
    val jimBob = friend(people, "Jim", "Bob")
    val testNet = friend(jimBob, "Bob", "Mary")
    println(testNet)

    def nFriends(network: Map[String, Set[String]], person: String) : Int =
        if(!network.contains(person)) 0
        else network(person).size

    def mostFriends(network: Map[String, Set[String]] ) : String =
        network.maxBy(pair => pair._2.size)._1

    def nPeopleWithNoFriends(network: Map[String, Set[String]] ) : Int =
//        network.filterKeys(key => network(key).isEmpty).size
//        network.filter(pair => pair._2.isEmpty).size
//        network.count(pair => pair._2.isEmpty)
        network.count(_._2.isEmpty)

    def socialConnection(network: Map[String, Set[String]] , a: String, b: String) : Boolean = {
        // TODO
        @tailrec
        def blfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]) : Boolean = {
            if(discoveredPeople.isEmpty) false
            else {
                val person = discoveredPeople.head
                if (person == target) true
                else if (consideredPeople.contains(person)) blfs(target, consideredPeople, discoveredPeople.tail)
                else blfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
            }
        }
        blfs(b, Set(), network(a) + a)
    }

    println(s"Bob has ${nFriends(testNet, "Bob")} friend(s)")
    println(s"${mostFriends(testNet)} has most friend(s)")
    println(s"${nPeopleWithNoFriends(network)} people has no friend")

    println(s"Mary and Jim has ${socialConnection(testNet, "Mary" ,"Jim")} social connection")
    println(s"Mary and Bob has ${socialConnection(testNet, "Mary" ,"Bob")} social connection")
    println(s"Mary and Bob has ${socialConnection(testNet, "Jim" ,"Bob")} social connection")





}
