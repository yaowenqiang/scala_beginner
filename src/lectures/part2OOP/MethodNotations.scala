package lectures.part2OOP
import scala.language.postfixOps


object MethodNotations extends  App {
    class Person(val name: String, movie : String, val age: Int = 0) {
        def likes(movie: String) : Boolean = movie == this.movie
        def hangoutWith(person: Person) :String = s"${this.name} hanging out with ${person.name}"
        def +(person: Person) :String = s"${this.name} hanging out with ${person.name}"
        def unary_! : String = s"$name, what the hack??"
        def isAlive: Boolean = true
        def apply() : String =  s"Hi, my name = ${name} and i like ${movie}"
        def apply(n: Int) : String =  s"${name} watched ${movie} ${n} times"
        def +(nick: String) :Person = new Person(s"${name} ${nick}", movie)
        def unary_+ : Person = new Person(name, movie, age+1)
        def learn(thing :String) = s"${name} is learning ${thing}"
        def learnScala = learn("Scala")

    }

    def mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))


    // infix notation - operator notation (syntax sugar)

    println(mary likes "Inception")

    def john = new Person("John", "Fighting Club")
    println(mary hangoutWith john)
    println(mary + john)
    println(mary.+(john))
    println((mary + "SuperStart")())
    println((mary + "SuperStart").apply())
    println(1 + 2)
    println(1.+(2))
    println(!mary)
    println("=========")
    println((+mary).age)
    println("=========")
    println(mary.learnScala)
    println(mary(10))


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
