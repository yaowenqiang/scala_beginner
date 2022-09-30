package exercises

object OOBasics extends App {
    val person = new Person("John", 16)
    println(person.age)
    println(person.x)
    person.greet("Jack")
    person.greet()

    val author = new Writer("Charies", "Dickens", 1812)
    val novel = new Novel("Great Expectations", 1861, author)
    println(novel.authorAge)
    println(novel.isWrittenBy(author))

    val counter = new Counter()
    counter.inc.print
    counter.inc.inc.inc.inc.print
    counter.inc(10).print


}

class Person(name: String, val age: Int) {
    var x = 2
    println(1 >2)

    def greet(name: String) :Unit = println(s"${this.name} says: Hi $name")
    def greet() : Unit = println(s"HI, i am ${name}")

    def this(name: String) = this(name, 0)
    def this() = this("foo")


}

class Writer(firstName: String, surName: String, val year: Int) {
    def fullName : String = firstName + " " + surName
}

class Novel(name: String, year: Int, author: Writer) {
    def authorAge = year - author.year
    def isWrittenBy(author: Writer) =  author == this.author
    def copy(newYear: Int) : Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
//   def count = count
    def inc = {
        println("Incrementing")
        new Counter(count + 1)
    }
    def dec = {
        println("Decrementing")
        new Counter(count - 1)
    }

    //    def inc(n: Int) = new Counter(count + n)
    //    def dec(n: Int) = new Counter(count - n)
    def inc(n: Int): Counter = {
        if (n <= 0) this
        else inc.inc(n-1)
    }
    def dec(n: Int): Counter = {
        if (n <= 0) this
        else dec.dec(n-1)
    }

    def print = println(count)


}
