package exercises

abstract class MyList[+A] extends App {
    def head :A
    def tail :MyList[A]
    def isEmpty :Boolean
    def add[B >: A](element: B) :MyList[B]
    def printElements: String
    override def toString : String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
    def head(): Nothing = throw new NoSuchElementException()
    def tail() :MyList[Nothing] = throw new NoSuchElementException()
    def isEmpty() :Boolean = true
    def add[B>: Nothing](element: B) :MyList[B] = new Cons(element, Empty)
    def printElements: String = ""
}

class Cons[+A](head: A, tail: MyList[A]) extends MyList[A] {
    def head() :A = head
    def tail() :MyList[A] = tail
    def isEmpty() :Boolean = false
    def add[B >: A](element: B) :MyList[B] = new Cons(element, this)
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
    val listOfIntegers : MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listOfStrings : MyList[String] = new Cons("hello", new Cons("world", new Cons("how are you", Empty)))
    println(listOfIntegers)
    println(listOfStrings)

}
