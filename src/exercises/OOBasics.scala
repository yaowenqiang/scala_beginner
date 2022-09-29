package exercises

object OOBasics extends App {
    val person = new Person("John", 16)
    println(person.age)
    println(person.x)
    person.greet("Jack")
    person.greet()
}

class Person(name: String, val age: Int) {
    var x = 2
    println(1 >2)

    def greet(name: String) :Unit = println(s"${this.name} says: Hi $name")
    def greet() : Unit = println(s"HI, i am ${name}")

    def this(name: String) = this(name, 0)
    def this() = this("foo")
}
