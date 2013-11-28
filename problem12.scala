val triangle = (n: Int) => n * ( n + 1 ) / 2
lazy val triangles = Stream.from(1).map(triangle(_))


lazy val prime: Stream[Int] = 2 #:: Stream.from(3, 2).filter(i => (2 to i).view.takeWhile(j => j * j <= i).forall(i % _ > 0))

val primes = prime.take(10000)



import scala.math._

val factor = (n:Int) => (for (p <- primes.takeWhile(_ * 2 <= n)) yield {
  if (n % p == 0)
    (p, (1 to (n / p) + 1).view.takeWhile(i => n % pow(p, i) == 0).last)
  else
    (p, 0)
}).filter(_._2 != 0).toList



println(triangles.map(t => (t,factor(t).map(_._2 + 1).product)).find(_._2 > 500).get._1)
