package lectures.part3FunctionalProgramming

// Higher Order Function
object HofAndCurryFunction extends  App {
    val superFunctions : (Int, (String, (Int => Boolean)) => Int)  => (Int => Int) = null
    def nTimes(f: Int => Int, n: Int, x: Int) : Int =
        if (n <= 0) x
        else
            nTimes(f, n-1, f(x))

    def nTimesBetter(f: Int => Int, n: Int) : (Int => Int) =
        if (n <= 0) (x: Int) => x
        else
            (x: Int) => nTimesBetter(f, n-1)(f(x))

    def plusOne = (x: Int) => x + 1

    println(nTimes(plusOne, 10, 1))
    val plusTen = nTimesBetter(plusOne, 10)
    println(plusTen(1))


    //curried functions

    val superAdder : Int => Int => Int = (x: Int) => (y: Int) => x + y
    val addThree = superAdder(3)
    println(addThree(10))
    println(superAdder(3)(10))

    def curriedFormatter(c: String)(x: Double) : String = c.format(x)

    val standardFormat :(Double => String) = curriedFormatter("%4.2f")
    val preciseFormat :(Double => String) = curriedFormatter("%10.8f")
    println(standardFormat(Math.PI))
    println(preciseFormat(Math.PI))

}
