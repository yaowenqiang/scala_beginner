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
    val colors = List("black", "white")
    // TODO
    val combinations = numbers.flatMap((n => characters.map(c => "" + c + n)))
    val combinations2 = numbers.flatMap((n => characters.flatMap((c => colors.map(color => "" + c + n + "-" + color)))))
    println(combinations)
    println(combinations2)

    // foreach
    list.foreach(println)

    // for comprehension
    val forComprehension = for {
        n <- numbers if n % 2 == 0
        c <- characters
        color <- colors
    } yield "" + c + n + "-" + color

    for  {
        n <- list
    } println(n)

    println(forComprehension)

    // syntax overload

    list.map (x =>
        x * 2
    )




}
