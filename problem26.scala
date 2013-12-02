import scala.math._

lazy val prime: Stream[Int] = 2 #:: Stream.from(3, 2).filter(i => (2 to i).takeWhile(j => j * j <= i).forall(i % _ > 0))

val factor = (n:Int) => (for (p <- prime.takeWhile(_ * 2 <= n)) yield {
  if (n % p == 0)
    (p, (1 to (n / p) + 1).view.takeWhile(i => n % pow(p, i) == 0).last)
  else
    (p, 0)
}).filter(_._2 != 0).toList ::: (if (prime.takeWhile(_ <= n).exists(_ == n)) List(n -> 1) else Nil)

val repeating_demical = (d: Int) => {
  val x = factor(d).filter(x => x._1 != 2 && x._1 != 5).map(x => pow(x._1, x._2).toInt).product
  (1 to d - 1).map(n => BigInt("1" + ("0" * n))% x).indexWhere(_ == 1) + 1
}

println((3 to 999).par.filter(d => d % 2 != 0 && d % 5 != 0).map(d => d -> repeating_demical(d)).maxBy(_._2)._1)
