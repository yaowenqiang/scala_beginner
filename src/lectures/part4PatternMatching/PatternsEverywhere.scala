package lectures.part4PatternMatching

object PatternsEverywhere extends App {
    try {

    } catch {
        case e: RuntimeException => "runtime"
        case npe: NullPointerException => "npe"
        case _ => "something else"
    }


//    try {
//
//    } catch  (e) {
//        e match {
//            case e: RuntimeException => "runtime"
//            case npe: NullPointerException => "npe"
//            case _ => "something else"
//        }
//    }

    val list = List(1,2,3,4)
    val even = for {
        x <- list  if x % 2 == 0
    } yield 10 * x
    // generator are also base on pattern matching
    val tuples = List((1,2), (3,4))
    val filterTuples = for {
        (first, second) <- tuples
    } yield first * second


    //case class ,:: operators, ...

    val tuple = (1,2,3)
    val (a, b,c) = tuple
    println(a,b,c)


    // multiple value definition based on patterns matching
    // all the powers

    val head :: tail = list

    //partial function based on pattern matching

    val mappedList = list.map{
        case v if v % 2 == 0 => s"$v is even"
        case 1 => "the one"
        case _ => "something else"
    }

    val mappedList2 = list.map(x => x match {
        case v if v % 2 == 0 => s"$v is even"
        case 1 => "the one"
        case _ => "something else"
    }) // partial function literal
    println(mappedList)


}
