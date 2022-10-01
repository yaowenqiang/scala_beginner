package lectures.part2OOP

object AbstractDataTypes extends App {
    abstract class Animal {
        val creatureType: String = "Canine"
        def eat: Unit
    }

    class Dog extends Animal {
//        override val creatureType: String = "Canine"
//        override def eat: Unit = println("crunch crunch")
        override  val creatureType: String = "Canine"
        def eat: Unit = println("crunch crunch")
    }

    // traits


    trait Carnivore {
        def eat(animal: Animal) :Unit
        val preferredMeal :String = "fresh meat"
    }

    trait CoolBlooded

    class Crocodile extends Animal with Carnivore with CoolBlooded {
        override val creatureType: String = "croc"
        def eat = println("nonono")
        def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
    }

    val dog = new Dog()
    val crok = new Crocodile
    crok.eat(dog)


    // traits vs abstract classes
    // 1, abstract class can have both abstract and non-abstract members, so can traits
    // 2, traits do not have constructor parameters
    // 3, multiple traits may be inherited by the same class
    // 4, traits = behaviors

    // scala.AnyVal => scala.Any extends scala.AnyRef
    // scala.Null
    // scala.Nothing






}
