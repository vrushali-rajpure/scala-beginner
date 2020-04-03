import scala.collection.mutable.{ArrayBuffer, ListBuffer}

trait Iterator[T] {
    def hasnext: Boolean
    def next(): T
}

class ListIterator(to : Int) extends Iterator[Int]{
    private var current = 0
    override def hasnext: Boolean = current < to

    override def next(): Int = {
        if( hasnext){
            val t = current
            current += 1
            t
        } else 0
    }
}

val t = new ListIterator(10)
t.next()
t.next()


trait Animal{
   val name : String
}

class Cat(val name : String) extends Animal

class Dog(val name : String) extends Animal

val cat = new Cat("cat")
val dog = new Dog("dog")

val animals = ArrayBuffer.empty[Animal];
animals.append(cat)
animals.append(dog)

animals.foreach(a => println(a.name))