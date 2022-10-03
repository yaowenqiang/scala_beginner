package lectures.part3FunctionalProgramming

object AnonymousFunctions extends App {
    def doubler2 = new Function1[Int, Int] {
        override def apply(x: Int): Int = x + 1
    }

    //anonymous function (lambda)
//    val doubler: Int => Int =  (x :Int) => x + 1
//    val doubler: Int => Int =  x => x + 1
    val doubler = (x: Int) => x + 1

//    val adder = (a: Int, b: Int) => a + b
    val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

    val getThree =  () => 3

    println(getThree)
    println(getThree())

    val stringToInt = {str: String =>
       str.toInt
    }

//    val increment :Int => Int = (x: Int) => x + 1
    val increment :Int => Int = _ + 1  // => x => x + 1
    val adder3 : (Int, Int) => Int  = (a: Int , b:Int) => a + b
    val adder4 : (Int, Int) => Int  =  _ + _ //  = (a, b) => a + b

    val superAdd = (x: Int) => (y: Int ) => x + y
    println(superAdd(1)(2))






}
