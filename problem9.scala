import scala.math._

val r = (1 to 998).flatMap(a => ((a + 1) to 999).filter(b => pow(1000 - a - b, 2) == pow(a, 2) + pow(b, 2)).map(b => (a, b, 1000 - a -
  b)))
val t = r(0)

println(t._1 * t._2 * t._3)
