package lectures.part2OOP

object AnonymousClasses extends  App {
    abstract class Animal {
        def eat: Unit
    }

    // Anonymous Classes
    // class AnonymousClasses$$anon$1 extends Animal
   val fancyAnimal : Animal = new Animal {
       override def eat: Unit = println("hahahaha")
   }

    class Person(name: String) {
        def sayHi : Unit = println(s"HI, my name is ${name}, How can i help?")
    }

    val jim = new Person("Jim")
    val john = new Person("John") {
        override def sayHi: Unit = println("Hi, my name is John, how can i be of service?")
    }
    println(john.getClass)



    println(fancyAnimal.getClass)

}
