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

## Sequences

A (very) general interface for data structures that 

+ have a well defined order
+ can be indexed

Supports various operations:

+ apply ,iterator, length, reverse for indexing and iterating
+ concatenation, appending, prepending
+ a lot of others grouping, sorting, searching ,slicing

## Range

## List

A LinearSeq immutable linked list
+ head, tail, isEmpty methods are fast: O(1)
+ most operations are O(n): length, reverse

Sealed - has two subtypes

+ object Nil(empty)
+ class ::

## Arrays

The equivalent type of Java arrays

+ Can be manually construct with predefined length
+ can be mutated(update or place)
+ are interoperable with Java's T[]arrays
+ indexing is fast


## Vector

The default implementation for immutable sequences

+ effectively constant indexed read write: O(log32(n))
+ Fast element addition: append/prepend 
+ implemented as a fixed-branched trie (branch factor 32)
+ good performance for large size
+ 