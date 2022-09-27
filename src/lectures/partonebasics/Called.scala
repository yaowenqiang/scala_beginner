package lectures.partonebasics

object Called extends App {
    def calledByValue(x: Long) :Unit = {
        println("By Value: ", + x)
        println("By Value: ", + x)
    }

    // called by name
    def calledByName(x: => Long) :Unit = {
        println("By Name: ", + x)
        println("By Name: ", + x)
    }

    def infinite() :Int = 1 + infinite()
    def printFirst(x :Int, y: => Int)  = println(x)
//    printFirst(infinite(), 30)
    printFirst(30,infinite())



    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())
}
