package lectures.part3FunctionalProgramming

object MapFlatmapFilterFor extends  App {
    val list =List(1,2,3)
    println(list)
    println(list.head)
    println(list.tail)
    println(list.filter(_ % 2 == 0))
    val toPair = list.flatMap((x :Int) => List(x, x + 1))
    println(toPair)

    val numbers = List(1,2,3,4)
    val characters = List('a', 'b', 'c', 'd')
    val combinations = numbers.flatMap((n => characters.map(c => "" + c + n)))
    println(combinations)


}
