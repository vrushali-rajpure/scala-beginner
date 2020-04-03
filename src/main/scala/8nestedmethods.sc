//In Scala it is possible to nest method definitions.

def factorial(number : Int) : Int = {
    def fact( number : Int, accumulator : Int) :Int = {
        if( number < 1) accumulator
        else fact( number - 1 , number * accumulator)
    }

    fact(number,1)
}

println(factorial(5))
println(factorial(10))