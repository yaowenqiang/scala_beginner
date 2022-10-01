package lectures.part2OOP

object InheritanceAndTraits extends App {
    sealed class Animal {
        val creatureType = "wild"
//        protected def eat = println("momomo")
          def eat = println("momomo")
    }
    // Single class inheritance

    class Cat extends Animal {
        def crunch = {
            eat
            println("crunch crunch")
        }
    }
    val cat = new  Cat
    cat.crunch


    // constructors
    class Person(name: String, age: Int) {
        def this(name: String) = this(name, 0)
    }
//    class Adult(name: String, age: Int, idCard : String) extends  Person(name, age)
    class Adult(name: String, age: Int, idCard : String) extends  Person(name)

    // overriding


//    class Dog extends Animal {
    class Dog(override val creatureType :String) extends Animal {
//        override val creatureType = "domestic"
        override def eat = {
            super.eat
            println("Dog crunch, crunch")
        }
    }
    class Dog2(dogType: String) extends Animal {
        override val creatureType: String  = dogType
    }
    val dog = new Dog("domestic")
    dog.eat
    println(dog.creatureType)


    // type substitution(polymorphism)

    val unknownAnimal : Animal = new Dog("K9")
    unknownAnimal.eat

    // super
    // preventing override
    // 1. final on method
    // 2. final on class
    // 3. seal the class - extend classes in THIS FILE, prevent extension in other files

}
