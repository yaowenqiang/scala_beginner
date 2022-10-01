package lectures.part2OOP

object Exceptions extends App {
    val x : String = null
//    println(x.length)
//    val aWiredValue :String = throw new NullPointerException
    // throwable class extends the Throwable class
    // exceptions and Error are the major throwable subtypes

    def getInt(withExceptions : Boolean) :Int = {
        if (withExceptions)
            throw new RuntimeException("no int for you")
        else 42
    }

    val potentialFail = try {
        getInt(true)
    } catch {
        case e: RuntimeException =>  println("caught a Runtime exception")
//        case e: NullPointerException =>  println("caught a Runtime exception")
    } finally {
        // code that will get executed NO MATTER WHAT
        // optional
        // does not influence the return type of this expression
        // use finally only for side effect

        println("finally")
    }

    println(potentialFail)


    class MyException extends Exception
    val newException = new MyException
//    throw newException

    // Out of memory
//    def array = Array.ofDim(Int.MaxValue)
    def infinite : Int = 1 + infinite
    // stack over flow
//    val noLimit = infinite


    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by zero")

    object PocketCalculator {
        def add(x: Int, y: Int) = {
            val result = x + y
            if(x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x > 0 && y > 0 && result > 0) throw new UnderflowException
            else result
        }
        def substract(x :Int, y: Int) :Int = {
            val result = x - y
            if (x > 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0)  throw new UnderflowException
            else result
        }

        def multiply(x :Int, y: Int) :Int = {
            val result = x * y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result < 0)  throw new UnderflowException
            else if (x > 0 && y < 0 && result > 0)  throw new UnderflowException
            else if (x < 0 && y > 0 && result > 0)  throw new UnderflowException
            else result
        }
        def divide(x :Int, y: Int) :Int = {
            if (y == 0) throw new MathCalculationException
            x / y
        }
    }

//    println(PocketCalculator.add(Int.MaxValue, 10))
//    println(PocketCalculator.substract(Int.MinValue, 10))
    println(PocketCalculator.divide(2, 0))

}
