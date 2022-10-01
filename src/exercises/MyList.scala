package exercises

abstract class MyList[+A] extends App {
    def head :A
    def tail :MyList[A]
    def isEmpty :Boolean
    def add[B >: A](element: B) :MyList[B]
    def printElements: String
    override def toString : String = "[" + printElements + "]"

    def map[B](transformer: MyTransformer[A, B]) :MyList[B]
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]) : MyList[B]
    def filter(predicate: MyPredicate[A]) : MyList[A]
    def ++[B >: A](list : MyList[B]) :MyList[B]
}


trait MyPredicate[-T] {
    def test(element: T) : Boolean
}

trait MyTransformer[-A, B] {
    def transform(element :A) : B
}


object Empty extends MyList[Nothing] {
    def head(): Nothing = throw new NoSuchElementException()
    def tail() :MyList[Nothing] = throw new NoSuchElementException()
    def isEmpty() :Boolean = true
    def add[B>: Nothing](element: B) :MyList[B] = new Cons(element, Empty)
    def printElements: String = ""
    def ++[B >: Nothing](list : MyList[B]) :MyList[B] = list

    def map[B](transformer: MyTransformer[Nothing, B]) :MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]) : MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]) : MyList[Nothing] = Empty
}

class Cons[+A](head: A, tail: MyList[A]) extends MyList[A] {
    def head() :A = head
    def tail() :MyList[A] = tail
    def isEmpty() :Boolean = false
    def add[B >: A](element: B) :MyList[B] = new Cons(element, this)
    def printElements: String =
        if (tail.isEmpty) "" + head
        else head + " " + tail.printElements

    def map[B](transformer: MyTransformer[A, B]) :MyList[B] =
        new Cons(transformer.transform(head), tail.map(transformer))

    def ++[B >: A](list : MyList[B]) :MyList[B] = new Cons(head, tail ++ list)

    def flatMap[B](transformer: MyTransformer[A, MyList[B]]) : MyList[B] =
        transformer.transform(head) ++ tail.flatMap(transformer)

    def filter(predicate: MyPredicate[A]) : MyList[A] =
        if (predicate.test(head)) new Cons(head, tail.filter(predicate))
        else tail.filter(predicate)

}

object listTest extends App {
//    val list = new Cons(1, Empty)
    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list.tail.head)
    println(list.add(4).head)
    println(list.isEmpty)
    println(list.toString)
    val listOfIntegers : MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listOfIntegers2 : MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
    val listOfStrings : MyList[String] = new Cons("hello", new Cons("world", new Cons("how are you", Empty)))
    println(listOfIntegers)
    println(listOfStrings)
    println(listOfIntegers.map(new MyTransformer[Int, Int] {
        override def transform(element: Int): Int = element * 2
    }).toString)

    println(listOfIntegers.filter(new MyPredicate[Int] {
        override def test(element: Int): Boolean = element % 2 == 0
    }).toString)

    println((listOfIntegers ++ listOfIntegers2).toString)

    println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
        // TODO
        override def transform(element: Int): MyList[Int] = new Cons[Int](element, new Cons(element + 1, Empty))
    }).toString)

}
