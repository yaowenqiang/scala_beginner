package lectures.part4PatternMatching

import exercises.MyList
import exercises.Cons
import exercises.Empty
object AllThePattern extends App {
    // 1. constants
    val x: Any = "Scala"
    val constants = x match {
        case 1 => "a Number"
        case "Scala" => "The Scala"
        case true => "The Truth"
        case AllThePattern => "A singleton object"
    }

    // 2. match anything
    // 2.1 wildcard
    val matchAnything = x match {
        case _ =>
    }

    // 2.2 variable
    val matchVariable = x match {
        case something => s"I've found $something"
    }
    // 2.3 tuples

    val aTuple = (1,2)
    val aTupleMatch = aTuple match {
        case (1,1) => ""
        case (something,2) => s"I've found $something"
    }

    val nestedTuple = (1, (2,3))
    val nestedTupleMatch = nestedTuple match {
        case (_ ,(2,v)) => ""
    }
    // PM can be nested

    // 4. case classes - constructor pattern

    //TODO
    val aList :MyList[Int] = new Cons(1, new Cons(2, Empty))
//    val matchedAList = aList match {
//        case Empty =>
//        case Cons(head, Cons(subhead, subtail)) =>
//    }

    // 5 list patterns

    val standardList = List(1,2,3,4)
    val standardListMatching = standardList match {
        case List(1,_,_,_) => // extractor = advanced
        case List(1,_*) => // list of arbitrary length = advanced
        case 1 :: List(_) => // infix pattern
        case List(1,2,3) :+ 42 =>  // infix pattern
    }
    // 6 type specifiers

    val unknown :Any = 2
    val unknownMatch = unknown match {
        case list: List[Int] => // explicit type specifier
        case _ =>
    }

    // 7 name binding

//    val namebindingMatch = aList match {
//        case nonEmptyList @ Cons(_,_) =>  // name binding => use the name later(here
//        case Cons(1, rest @ Cons(1, _)) => // name bind inside patterns
//    }

    // 8 multi patterns

//    val multiPattern = aList match {
//        case Empty | Cons(0, _) =>   //compoundPattern or multipattern
//    }

//    // 9 if guard
//    val secondElementSpecial = aList match {
//        case Cons(1, Cons(specialElement, _)) if specialElement % 2 == 0 =>
//    }

    // ALL

    val numbers = List(1,2,3,4)
    val numbersMatch = numbers match {
        case listOfStrings :List[String] => "A list of strings"
        case listOfNumbers :List[Int] => " A list of numbers"
        case _ => ""
    }
    println(numbersMatch)
    // JVM trick question






}
