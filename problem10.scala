lazy val prime: Stream[Int] = 2 #:: Stream.from(3).filter(i => prime.takeWhile(j => j * j <= i).forall(i % _ > 0))

val primes = prime.takeWhile(_ < 2000000).map(_.toLong)

println(primes.sum)
