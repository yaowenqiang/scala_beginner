package lectures.part2OOP

object CaseClasses extends App {
    case class Person(name: String, age: Int)
    // 1, class parameters are fields
    val jim = new Person("Jim", 32)
    println(jim.age)
    // 2,  sensible toString
    // println(instance) = println(instance.toString) - syntastic sugar
    println(jim.toString)
    println(jim)
    // equals and hashcode implemented OOTB
    val jim2 = new Person("Jim", 34)
    println(jim2 == jim)
    // 4 CCs have handy copy method

    val jim3 = jim.copy(age = 45)
    println(jim3)

    // 5. CCss have companion objects
    val thePerson = Person
    val mary = Person("Mary", 23) // person.apply

    // 6. CCs are serializable
    // AKKA

    // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

    case object UK {
        def name : String = "This is a case object"
    }






}
