// lazy val numbers:Stream[BigInt] = (2520 / 20) #:: numbers.map(_ + 1)
// val nums = (1 to 20).filter(20 % _ != 0)
// println(numbers.map(_ * 20).par.filter(n => nums.forall(n % _ == 0)).head)

import scala.math._

// lazy val _prime: Stream[Long] = 3 #:: _prime.map(p => ((p + 2) to (p * 2) by 2).par.filter(n => (2 #:: _prime).takeWhile(_ < p).par.forall(n % _ != 0)).head)
// lazy val prime = 2 #:: _prime

lazy val prime: Stream[Int] = 2 #:: Stream.from(3).filter(i => prime.takeWhile(j => j * j <= i).forall(i % _ > 0))

val primes = prime.takeWhile(_ < 20)



val xs = for (p <- primes) yield {
  (1 to 5).takeWhile(20.0 / pow(p , _) > 1).map(_ => p).product
}

println(xs.product)

