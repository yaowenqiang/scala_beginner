package lectures.part2OOP

//object Objects extends App {
object Objects {
   object Person {
       // "static"/"class" level functionality
       val N_EYS = 2
       def canFly : Boolean = false
       // factory method
       def from(mother: Person, father: Person) : Person = new Person("Bobby")
       def apply(mother: Person, father: Person) : Person = new Person("Bobby")
   }
    class Person(val name: String) {
        // Instance level functionality

    }
    def main(args: Array[String]) : Unit = {

        // COMPANIONS

        println(Person.N_EYS)
        println(Person.canFly)
        val mary = Person
        val john = Person
        println(mary == john)


        val jack = new Person("Jack")
        val joy = new Person("Joy")

        print(jack == joy)

    //    val bobby = Person.from(jack, joy)
        val bobby = Person(jack, joy)

        // scala applications = Scala object with
        // def main(args: Array[String] : Unit

    }




}
