package lectures.partonebasics

object StringOps extends App {
   val str: String = "Hello, I am learning Scala"
    println(str.charAt(2))
    println(str.substring(7, 11))
    println(str.split(' ').toList)
    println(str.startsWith("Hello"))
    println(str.replace(' ', '-'))
    println(str.toUpperCase())
    println(str.toLowerCase())
    println(str.length)

    val numberString = "43"
    println('a' +: numberString :+ 'z')
    println(numberString.toInt)
    var a = "a"
    println("b" +: a)

    println("ABC".reverse)

    println("ABC".take(1))



    // s interpolator
    val name = "David"
    val age = 20
    val greeting = s"Hello, my name is $name, i am $age years old"
    println(greeting)

    val greeting2 = s"Hello, my name is $name, i am going to be ${age + 1}  years old"
    println(greeting2)

    // f interpolator

    val speed = 1.2f
    val math = f"$name%s can eat $speed%2.2f burgers per minute"
    println(math)


    // raw interpolator
    println(raw"This is a \n newline")
    val escaped = "This is a \n newline"
    println(raw"$escaped")

}
