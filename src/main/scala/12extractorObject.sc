import scala.util.Random

/*
An extractor object is an object with an unapply method.

 Whereas the apply method is like a constructor
 which takes arguments and creates an object,
 the unapply takes an object and tries to give back the arguments.
 This is most often used in pattern matching and partial functions.
 */

object CustomerID {

    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
        val splitArray: Array[String] = customerID.split("--")
        if (splitArray.tail.nonEmpty) Some(splitArray.head) else None
    }
}

/*
The apply method creates a CustomerID string from a name.
The unapply does the inverse to get the name back.
When we call CustomerID("Sukyoung"),
 this is shorthand syntax for calling CustomerID.apply("Sukyoung").
  When we call case CustomerID(name) => println(name),
   we’re calling the unapply method.
 */

val customer1ID = CustomerID("Sukyoung") //apply
customer1ID match { // unapply
    case CustomerID(nameCust) => println("**" + nameCust) // prints Sukyoung
    case _ => println("Could not extract a CustomerID")
}

/*
Since a value definition can use a pattern to introduce a
new variable, an extractor can be used to initialize the
variable, where the unapply method supplies the value.
 */

val customer2ID = CustomerID("Nico")
val CustomerID(name) = customer2ID // equivalent to val name = CustomerID.unapply(customer2ID).get.
println(name) // prints Nico


val CustomerID(name2) = "--asdfasdfasdf"