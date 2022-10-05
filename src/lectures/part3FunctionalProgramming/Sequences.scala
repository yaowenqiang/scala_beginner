package lectures.part3FunctionalProgramming

import scala.util.Random

object Sequences extends App {
    val aSequence = Seq(1,2,7,9,3,4)
    println(aSequence)
    println(aSequence.reverse)
    println(aSequence(2))
    println(aSequence ++ Seq(5,6,7))
    println(aSequence.sorted)

    // Range
//    val aRange : Seq[Int]  = 1 to 10
    val aRange : Seq[Int]  = 1 until  10
//    println(aRange)
    aRange.foreach(println)
    (1 to 10).foreach(a => println("hello"))


    // List

    var aList = List(1,2,3)
//    val prepended = 42 :: aList
    val prepended = 42 +: aList :+ 24
    println(prepended)

    val fiveApple = List.fill(5)("apple")
    println(fiveApple)
    println(aList.mkString("- | -"))

    // Arrays
    val numbers = Array(1,2,3,4)
    val threeElements = Array.ofDim[Int](3)
//    println(threeElements)
    threeElements.foreach(println)
    numbers(2) = 0  // syntax sugar for numbers.update(2,0)
    println(numbers.mkString(" "))


    // arrays and sequences

    val numbersSequences :Seq[Int] = numbers  // implicit conversion
    println(numbersSequences)


    // Vector

    val vector: Vector[Int] = Vector(1,2,3)
    println(vector)

    //vector vs lists

    val maxRuns :Int = 1000
    val maxCapacity = 1000000
    def getWriteTime(collection: Seq[Int]) : Double = {
        val r = new Random
        val times = for {
            it <- 1 to maxRuns
        } yield {
           val currentTime = System.nanoTime
            // operation
//            collection.updated(r.nextInt(maxCapacity), 0)
            collection.updated(r.nextInt(maxCapacity), r.nextInt())

            System.nanoTime - currentTime
        }

        times.sum * 1.0 / maxRuns


    }

    // keeps references to tail
    // updating an element in the middle takes long
    val numberLists = (1 to maxCapacity).toList
    // depth of the tree is small
    // needs to replace an entire 32 element chunk
    val numberVector = (1 to maxCapacity).toVector
    println(getWriteTime(numberLists))
    println(getWriteTime(numberVector))





}
