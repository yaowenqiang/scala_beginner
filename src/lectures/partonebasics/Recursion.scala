package lectures.partonebasics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {
//    @tailrec
    def factorial(n: Int) :Int =
        if (n <= 1) 1
        else {
            println("computing factorial of " + n + "-1 first need factorial of " + (n-1))
            var result = n * factorial(n-1)
            println("computed factorial of " + n)
            result
        }

    def anotherFactorial(n: Int) :BigInt = {
        @tailrec
        def factHelper(x: Int, accumulator: BigInt) :BigInt =
            if (x < 1) accumulator
            else factHelper(x-1, x*accumulator)

        // the recursive function mast be last expression
        factHelper(n, 1)
    }

    @tailrec
    def concatenateTailrec(aString :String, n :Int, accumulator: String) :String = {
        if (n <=0) accumulator
        else concatenateTailrec(aString, n-1, aString + accumulator)
    }

    println(concatenateTailrec("hello", 10, ""))

//    println(factorial(10))
//    println(anotherFactorial(5))

    def isPrime(n: Int) :Boolean =  {
        @tailrec
        def isPrimeTailrec(t: Int, isStilPrim: Boolean) : Boolean =
            if (!isStilPrim) false
            else if (t <= 1) true
            else isPrimeTailrec(t-1, n % t != 0 && isStilPrim)
        isPrimeTailrec(n / 2, true)
    }

    println(isPrime(2031))

    def fiiboonacci(n: Int) :Int = {
        def fibTailrec(i: Int, last: Int ,nextLast :Int) : Int =
            if (i >= n ) last
            else fibTailrec(i+1, last + nextLast, last)

        if (n <= 2) 1
        else fibTailrec(2, 1,1)
    }

    print(fiiboonacci(8))

}
