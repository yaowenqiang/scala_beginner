package lectures.partonebasics

object Functions extends App {
    def aFunction(a: String, b: Int) :String  =
        a + ' ' + b

    def b() :Int = 42

//    println(b())
    println(b)

    println(aFunction("Hello" ,3))

    def aRepeatFunction(s: String, n: Int) : String =
        if (n == 1) s else s + aRepeatFunction(s,n-1)

    println(aRepeatFunction("a", 100))

    def aFunctionWithSideEffects(s :String) : Unit = println(s)
    print(aFunctionWithSideEffects("aFunctionWithSideEffects"))

    def aBigFunction(a: Int) : Int = {
        def aSmallFunction(i :Int, j :Int) : Int = i + j
        aSmallFunction(a, a + 1)
    }

    def greetingForKids(name :String, age: Int) :String =
        "HI, my name is " + name + " i am " + age + " Years old."

   def factorial(n: Int) :Int =
       if (n <= 0) 1
       else n * factorial(n-1)

    println(factorial(10))

   def fibonacci(n: Int) :Int =
       if (n <= 1) 1
       else fibonacci(n-1) + fibonacci(n-2)

    println(fibonacci(2))
//    println(fibonacci(20))
//    println(fibonacci(40))
//    println(fibonacci(80))

    def isPrime(n: Int) :Boolean =  {
        def isPrimeUntil(t: Int) :Boolean =
            if (t <=1) true
            else n % t != 0 && isPrimeUntil(t-1)

        isPrimeUntil(n / 2)
    }

    println(isPrime(37))
    println(isPrime(38))





}

