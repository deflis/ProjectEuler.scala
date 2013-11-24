import scala.math._
val n = (BigInt(1) to 100).sum
println((n * n) - (BigInt(1) to 100).map(n => n * n).sum)
