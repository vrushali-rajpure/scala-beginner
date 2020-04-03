//Methods may have multiple parameter lists.

// example from TraversableOnce trait
// def foldLeft[B](z: B)(op: (B, A) => B): B

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val res = numbers.foldLeft(0)((m, n) => m + n)
println(res) // 55

// ------------ USE CASES : PARTIAL APPLICATION

/*  When a method is called with a fewer number of parameter
   lists, then this will yield a function taking the missing
   parameter lists as its arguments.
   This is formally known as partial application. */

val numberFunc = numbers.foldLeft(List[Int]()) _

val squares = numberFunc((xs, x) => xs :+ x*x)
print(squares) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

val cubes = numberFunc((xs, x) => xs :+ x*x*x)
print(cubes)  // List


/*
:: - adds an element at the beginning of a list and returns a list with the added element
::: - concatenates two lists and returns the concatenated list
 */
val list1 = List(1,2)
val list2 = List(3,4)

"list1::list2--"
list1::list2

list1:::list2

1 :: list1 :: list2

