package lectures.part3FunctionalProgramming

object WhatsFunction extends App {
   val double = new MyFunction[Int, Int] {
       override def apply(element: Int): Int = element * 2
   }
    println(double(2))
    // function types

    val stringToIntConverter = new Function[String, Int] {
        override def apply(string: String): Int = string.toInt
    }
    def stringToIntConverterV2(string :String) :Int = string.toInt

    println(stringToIntConverter("3") + 4)
    println(stringToIntConverterV2("3") + 4)

    val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
        override def apply(a: Int, b: Int): Int = a + b
    }
    println(adder(1,2))


    // function types  Funciton2(A,B,R) === (A, B) => R

    // All SCALA fUNCTIONS ARE OBJECTS

    def concatenator:(String, String) => String = new Function2[String, String, String] {
        override def apply(a: String, b: String): String = a + b
    }

    println(concatenator("Hello", "Scala"))


    val superAdder : Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
        override def apply(x: Int): Function1[Int , Int] = new Function1[Int, Int] {
            override def apply(y: Int): Int = x + y
        }
    }

    val adder3 = superAdder(3)
    println(adder3(2))
    println(superAdder(3)(2)) // curried function

}


class Action {
    def execute(element: Int) :String = ???
}

trait MyFunction[A,B] {
    def apply(element: A) :B
}
