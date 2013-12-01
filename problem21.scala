lazy val prime: Stream[Int] = 2 #:: Stream.from(3, 2).filter(i => (2 to i).takeWhile(j => j * j <= i).forall(i % _ > 0))

val primes = prime.take(10000).toList

import scala.math._

val factor = (n:Int) => (for (p <- primes.takeWhile(_ * 2 <= n)) yield {
  if (n % p == 0)
    (p, (1 to (n / p) + 1).view.takeWhile(i => n % pow(p, i) == 0).last)
  else
    (p, 0)
}).filter(_._2 != 0).toList

val d = (n:Int) => {
  val f = factor(n)
  if (f.isEmpty) {
    1
  } else {
    f.map(t => (pow(t._1, t._2 + 1) - 1) / (t._1 - 1)).product.toInt - n
  }
}

val dn = (1 to 10000).map(n => n -> d(n))

println(dn.filter(x => x._1 != x._2 && x._1 == d(x._2)).map(_._1).sum)
