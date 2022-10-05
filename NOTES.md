# Immutable Collections

> scala.collections.immutable package

Traversable 
+ Iterable
  + Set
    + HashSet
    + SortedSet
  + Map
    + HashMap
    + SortedMap
  + Seq
    + IndexedSeq
      + Vector
      + String
      + Range
    + LinearSeq
      + List
      + Stream
      + Stack
      + Queue
      
# Mutable Collections

> scala.collections.mutable package

Traversable
+ Iterable
    + Set
        + HashSet
        + LinkedHashSet
    + Map
        + HashMap
        + MultiMap
    + Seq
        + IndexedSeq
            + StringBuilder
            + ArrayBuffer
        + LinearSeq
            + LinkedList
            + MutableList
        + Buffer
            + ListBuffer
            + ArrayBuffer

# Traversable

Base trait for all collections.Offers a great variety of methods:

+ maps: map, flatmap, collect
+ conversions: toArray, toList, toSeq
+ size info: isEmpty, size, nonEmpty
+ tests: exists, forall
+ folds: foldLeft, foldRight,reduceLeft, reduceRight
+ retrieval: head ,find, tail
+ string ops: mkString