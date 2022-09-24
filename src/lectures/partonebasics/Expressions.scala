package lectures.partonebasics

object Expressions extends App {
    val x = 1 + 2
    println(x)
    println(x > 2)

    val acondition = true
    val aconditionValue = if (acondition) 5 else 3
    println(aconditionValue)
    println(if (acondition) 5 else 3)

    var z = 0
    var awhilevalue = while (z < 10) {
        println(z)
        z += 1
    }

    var avalue1 = 2
    val avalue2 =  (avalue1 = 3)
    println(avalue2)
    val codeBlock = {
        val y = 2
        var z = y + 1
//        if (z > 2) "hello" else "goodbye"
        if (z > 2) "hello" else 1
    }
    println(codeBlock)


}
