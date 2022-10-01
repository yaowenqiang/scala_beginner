package lectures.part2OOP

import javax.management.InvalidApplicationException

object Generics extends App {
//    trait MyList[A] {
    class MyList[+A] {
//        def add(element: A) :MyList[A] = ???
//        def add[B >: A](element: B) :MyList[B] = ???
    }

    class MyMap[Key, Value] {

    }

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]


    object MyList {
        def empty[A]: MyList[A] = ???
    }

    val emptyListOfIntegers = MyList.empty[Int]


    // variance problem

    class Animal
    class Cat extends Animal
    class Dog extends Animal

    //1. yes list[Cat] extends list[Animal] = covariance

    class CovariantList[+A]
    val animal : Animal = new Animal
    val animalList :CovariantList[Animal] = new CovariantList[Cat]
//    animalList.add(new Dog)
// 2. no = invariance
    class InvariantList[A]

    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

   // 3 hell, no! CONTRAVARIANCE

   class ContravarianceList[-A]

    class Trainer[-A]
//    val contravarianceList : ContravarianceList[Cat] = new ContravarianceList[Animal]
    val trainer: Trainer[Cat] = new Trainer[Animal]


    // bounded types


    class Cage[A <: Animal ](animal: A)
    class Car
    val cage = new Cage(new Dog)
//    val cage2 = new Cage(new Car)

}
