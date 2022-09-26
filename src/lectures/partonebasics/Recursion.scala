package lectures.partonebasics

object Recursion extends App {
    def factorial(n: Int) :Int =
        if (n <= 1) 1
        else {
            println("computing factorial of " + n + "-1 first need factorial of " + (n-1))
            var result = n * factorial(n-1)
            println("computed factorial of " + n)
            result
        }

    def anotherFactorial(n: Int) :BigInt = {
        def factHelper(x: Int, accumulator: BigInt) :BigInt =
            if (x < 1) accumulator
            else factHelper(x-1, x*accumulator)
        factHelper(n, 1)
    }


    println(factorial(10))
    println(anotherFactorial(5000))
}
