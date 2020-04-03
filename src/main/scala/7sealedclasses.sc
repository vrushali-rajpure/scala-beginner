/*
Traits and classes can be marked sealed
which means all subtypes must be declared
in the same file.
This assures that all subtypes are known.
 */

sealed class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture


def findPlaceToSeat( f : Furniture) : String = f match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
}

findPlaceToSeat(Chair())