package lectures.part2OOP
import scala.language.postfixOps


object MethodNotations extends  App {
    class Person(val name: String, movie : String) {
        def likes(movie: String) : Boolean = movie == this.movie
        def hangoutWith(person: Person) :String = s"${this.name} hanging out with ${person.name}"
        def +(person: Person) :String = s"${this.name} hanging out with ${person.name}"
        def unary_! : String = s"$name, what the hack??"
        def isAlive: Boolean = true
        def apply() : String =  s"Hi, my name = ${name} and i like ${movie}"
    }

    def mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))


    // infix notation - operator notation (syntax sugar)

    println(mary likes "Inception")

    def john = new Person("John", "Fighting Club")
    println(mary hangoutWith john)
    println(mary + john)
    println(mary.+(john))
    println(1 + 2)
    println(1.+(2))
    println(!mary)


    //ALL OPERATORS ARE METHODS
    // Akka actors have ! ?

    // prefix notation

    val x = -1
    val y = 1.unary_-
    //unary_prefix only works with - + ~ !

    // postfix notation
    println(mary.isAlive)
    println(mary isAlive) // rare used

    // apply
    println(mary.apply)
    println(mary.apply())
    println(mary())












    //operators in Scala


}
