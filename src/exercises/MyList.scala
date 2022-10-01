package exercises

abstract class MyList extends App {
    def head :Int
    def tail :MyList
    def isEmpty :Boolean
    def add(element: Int) :MyList
    def printElements: String
    override def toString : String = "[" + printElements + "]"
}

object Empty extends MyList {
    def head() :Int = throw new NoSuchElementException()
    def tail() :MyList = throw new NoSuchElementException()
    def isEmpty() :Boolean = true
    def add(element: Int) :MyList = new Cons(element, Empty)
    def printElements: String = ""
}

class Cons(head: Int, tail: MyList) extends MyList {
    def head() :Int = head
    def tail() :MyList = tail
    def isEmpty() :Boolean = false
    def add(element: Int) :MyList = new Cons(element, this)
    def printElements: String =
        if (tail.isEmpty) "" + head
        else head + " " + tail.printElements
}

object listTest extends App {
//    val list = new Cons(1, Empty)
    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list.tail.head)
    println(list.add(4).head)
    println(list.isEmpty)
    println(list.toString)
}
