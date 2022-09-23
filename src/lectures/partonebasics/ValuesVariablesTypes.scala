package lectures.partonebasics

object ValuesVariablesTypes extends App {
//  val x: Int = 42
  val x = 42
//  x = 2
  println(x)

  val astring: String = "hello"
  println(astring)

  val aboolean: Boolean = false
  println(aboolean)
  var achar: Char = 'c'
  var along : Long = 400000000
  var anotherlong : Long = 400000000L
  println(achar)
//  var ashort : Short = 400000000
//  println(ashort)
  println(along)
  println(anotherlong)

  var afloat :Float = 2.5f
  var adouble :Double = 2.5d
  println(afloat)
  println(adouble)

  var a :Int = 5
  a = 6
  println(a)
}
