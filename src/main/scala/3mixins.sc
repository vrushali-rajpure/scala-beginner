abstract class A{
    val message : String
}

trait C extends A{
    def loudMessage = message.toUpperCase()
}

class B extends A {
    val message = "I'm an instance of class B"
}

class D extends B with C

val d = new D
println(d.message)
println(d.loudMessage)

abstract class AbsIterator {
    type T
    def hasNext: Boolean
    def next(): T
}