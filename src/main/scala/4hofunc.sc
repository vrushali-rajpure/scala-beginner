val seq = Seq(100,200,400)

def doubleSalary = (sal : Int ) => sal * 2

val doubleSals = seq.map(doubleSalary)

print(doubleSals)

println(seq.map(sal => sal * 2))

println(seq.map(_ * 2))

//---------------------- Coercing methods into functions

case class WeeklyWeatherForecast(temperatures : Seq[Double]) {

    private def convertCToF(temp : Double) = temp  * 1.8 + 32

    def convertAllFunc: Seq[Double] = temperatures.map(convertCToF)  // <-- passing the method convertCtoF
}

println(WeeklyWeatherForecast(Seq(100,110)).convertAllFunc)

//------- One reason to use higher-order functions is to reduce redundant code

object SalaryRaiser {
    def smallRaiser(sals : List[Double]) : List[Double] =
        sals.map(sal => sal * 0.10)

    def mediumRaiser(sals : List[Double]) : List[Double] =
        sals.map(sal => sal * 0.20)

    def highRaiser(sals : List[Double]) : List[Double] =
        sals.map(sal => sal * 0.30)
}


// Notice how each of the three methods vary only by the multiplication factor.
// we can extract the repeated code into a higher-order function like so:

object SalaryRaiserHighOrder {
    def promote( sals: List[Double], promoFunc : Double => Double) : List[Double] = sals.map(promoFunc)

    def smallRaiser(sals : List[Double]) : List[Double] = promote(sals, sal => sal * 0.10)
    def mediumRaiser(sals : List[Double]) : List[Double] = promote(sals, sal => sal * 0.20)
    def highRaiser(sals : List[Double]) : List[Double] = promote(sals, sal => sal * 0.30)
}

println(SalaryRaiserHighOrder.highRaiser(List(100,200)))


//--------------------------- Functions that return functions

def urlBuilder(ssl : Boolean, domainName: String ) : (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
}

val domainName = "www.example.com"
def getURL = urlBuilder(ssl=true, domainName)
val endpoint = "users"
val query = "id=1"
val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
