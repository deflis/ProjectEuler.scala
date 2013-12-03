lazy val prime: Stream[Int] = 2 #:: Stream.from(3, 2).filter(i => (2 to i).takeWhile(j => j * j <= i).forall(i % _ > 0))

val primes = prime.takeWhile(_ < 1000).toList

println(primes.tail.flatMap(b => primes
  .map(p => p - b - 1)
  .filter(a => -1000 < a && a < 1000)
  .map(a => (a * b, Stream.from(0).map(n => n * n + a * n + b).takeWhile(p => prime.takeWhile(_ <= p).exists(_ == p)).length))
).maxBy(_._2)._1)
