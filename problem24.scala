
implicit class FactInt(val n : Int) {
  def ! = (1 to n).product
}
import scala.language.postfixOps

def list (n: Int) = {
  def fn (l: List[Int]) : List[Int] = {
    val nl = (0 to 9).filter(!l.contains(_))
    if (l.size == 9) { nl.head :: l } else {
      val i = (9 - l.length)
      var x = nl((n / (i!)) % (i + 1))
      fn( x :: l )
    }
  }
  fn(n / (9!) :: Nil).foldLeft("")(_ + _).reverse
}

println(list(0))
println(list(1))
println(list(2))
println(list(1000000 - 1))
println(list(1000000))
