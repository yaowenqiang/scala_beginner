package exercises

import scala.runtime.Nothing$

abstract class MyList[+A] {
    def head :A
    def tail :MyList[A]
    def isEmpty :Boolean
    def add[B >: A](element: B) :MyList[B]
    def printElements: String
    override def toString : String = "[" + printElements + "]"

    def map[B](transformer: A => B) :MyList[B]
    def flatMap[B](transformer: A => MyList[B]) : MyList[B]
    def filter(predicate: A => Boolean) : MyList[A]

    def ++[B >: A](List: MyList[B]): MyList[B]
    // HOFs
    def foreach(f: A => Unit) :Unit
    def sort(compare: (A,A) => Int) :MyList[A]
    def zipWith[B, C](list: MyList[B], zip:(A,B)=>C):MyList[C]
    def fold[B](start: B)(operator: (B, A) => B):B
    def toCurry(f: (Int, Int) => Int) : (Int => Int => Int) =
        x => y => f(x, y)
    def fromCurry(f: (Int =>  Int => Int)): (Int, Int) => Int =
        (x, y) => f(x)(y)

//    def compose(f: Int => Int, g: Int => Int) :Int => Int =
//        x => f(g(x))
    def compose[A, B, T](f: A => B, g: T => A) :T => B =
        x => f(g(x))

    def andThen[A,B,C](f: A => B, g: B => C) :A => C =
        x => g(f(x))

    def superAdder2: (Int => Int => Int) = toCurry(_ + _)
    def add4 = superAdder2(4)
//    println(add4(17))
    def simpleAdder = fromCurry(superAdder2)
//    println(simpleAdder(4, 17))


}


//trait MyPredicate[-T] {
//    def test(element: T) : Boolean
//}
//
//trait MyTransformer[-A, B] {
//    def transform(element :A) : B
//}


case object Empty extends MyList[Nothing] {
    def head(): Nothing = throw new NoSuchElementException()
    def tail() :MyList[Nothing] = throw new NoSuchElementException()
    def isEmpty() :Boolean = true
    def add[B>: Nothing](element: B) :MyList[B] = new Cons(element, Empty)
    def printElements: String = ""
    def ++[B >: Nothing](list : MyList[B]) :MyList[B] = list

    def map[B](transformer: Nothing => B) :MyList[B] = Empty
    def flatMap[B](transformer: Nothing => MyList[B]) : MyList[B] = Empty
    def filter(predicate: Nothing => Boolean) : MyList[Nothing] = Empty
    def foreach(f: Nothing => Unit) :Unit = ()
    def sort(compare: (Nothing, Nothing) => Int) = Empty
    def zipWith[B, C](list: MyList[B], zip:(Nothing,B)=>C):MyList[C] = {
        if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
        else Empty
    }

    def fold[B](start: B)(operator: (B, Nothing) => B):B = start
}

//case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A] {
class Cons[+A](head: A, tail: MyList[A]) extends MyList[A] {
    def head() :A = head
    def tail() :MyList[A] = tail
    def isEmpty() :Boolean = false
    def add[B >: A](element: B) :MyList[B] = new Cons(element, this)
    def printElements: String =
        if (tail.isEmpty) "" + head
        else head + " " + tail.printElements

    def map[B](transformer: A => B) :MyList[B] =
        new Cons(transformer(head), tail.map(transformer))

    def ++[B >: A](list : MyList[B]) :MyList[B] = new Cons(head, tail ++ list)

    def flatMap[B](transformer: A => MyList[B]) : MyList[B] =
        transformer(head) ++ tail.flatMap(transformer)

    def filter(predicate: A => Boolean) : MyList[A] =
        if (predicate(head)) new Cons(head, tail.filter(predicate))
        else tail.filter(predicate)

    def foreach(f: A => Unit): Unit = {
        f(head)
        tail.foreach(f)
    }

    def sort(compare: (A,A) => Int): MyList[A] = {
        def insert(x: A, sortedList: MyList[A]) : MyList[A] = {
            if (sortedList.isEmpty) new Cons(x, Empty)
            else if (compare(x , sortedList.head)<= 0) new Cons(x, sortedList)
            else new Cons(sortedList.head, insert(x, sortedList.tail))
        }

        val sortedTail = tail.sort(compare)
        insert(head, sortedTail)
    }

    def zipWith[B, C](list: MyList[B], zip:(A,B)=>C):MyList[C] = {
        if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
        else
            new Cons(zip(head, list.head),tail.zipWith(list.tail, zip))

    }


    def fold[B](start: B)(operator: (B, A) => B):B =
        tail.fold(operator(start, head))(operator)

}

object listTest extends App {
//    val list = new Cons(1, Empty)
    val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list.tail.head)
    println(list.add(4).head)
    println(list.isEmpty)
    println(list.toString)
    val listOfIntegers : MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
//    val copiedListOfIntegers : listOfIntegers.clone()
//    println(copiedListOfIntegers == listOfIntegers)
    val listOfIntegers2 : MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
    val listOfStrings : MyList[String] = new Cons("hello", new Cons("world", new Cons("how are you", Empty)))
    val anotherListOfStrings : MyList[String] = new Cons("hello", new Cons("world", new Cons("how are you", Empty)))
    println(listOfIntegers)
    println(listOfStrings)
//    println(listOfIntegers.map(new Function1[Int, Int] {
//        override def apply(element: Int): Int = element * 2
//    }).toString)

//        println(listOfIntegers.map(elem => elem * 2).toString)
        println(listOfIntegers.map(_ * 2).toString)

    //    println(listOfIntegers.filter(new Function1[Int, Boolean] {
//        override def apply(element: Int): Boolean = element % 2 == 0
//    }).toString)
//    println(listOfIntegers.filter(elem => elem % 2 == 0).toString)
    println(listOfIntegers.filter(_ % 2 == 0).toString)

    println((listOfIntegers ++ listOfIntegers2).toString)

//    println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
//        override def apply(element: Int): MyList[Int] = new Cons[Int](element, new Cons(element + 1, Empty))
//    }).toString)
    println(listOfIntegers.flatMap(elem  => new Cons(elem, new Cons(elem + 1, Empty))).toString)
    listOfIntegers2.foreach(println)
    println(listOfIntegers2.sort((x, y) => y -x))
    println(listOfStrings.zipWith[String, String](anotherListOfStrings, _ + "-" + _))
    println(listOfIntegers.fold(0)(_ + _))

    val add2 = (x: Int)  => x + 2
    val times3 = (x: Int) => x * 3

    def compose[A, B, T](f: A => B, g: T => A) :T => B =
        x => f(g(x))

    def andThen[A,B,C](f: A => B, g: B => C) :A => C =
        x => g(f(x))

    val composed = compose(add2, times3)
    val ordered = andThen(add2, times3)
    println(composed(4)) // 4 * 3 + 2
    println(ordered(4)) // (4 + 2) * 3

    // for comprehension

    val combination = for {
        n <- listOfIntegers2
        string <- listOfStrings
    } yield n + "-" + string
    println(combination)


    println( for {
        n <- listOfIntegers2
        string <- listOfStrings
    } yield n + "-" + string)




}
