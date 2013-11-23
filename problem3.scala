import scala.math.sqrt

lazy val _prime: Stream[Long] = 3 #:: _prime.map(p => ((p + 2) to (p * 2) by 2).par.filter(n => (2 #:: _prime).takeWhile(_ < p).par.forall(n % _ != 0)).head)
lazy val prime = 2 #:: _prime

// val f = (num: Long) => println(prime.takeWhile(_ < sqrt(num)).par.filter(num % _ == 0).last)

val isPrime = (n: Long) => prime.filter(_ < sqrt(n)).forall(n % _ != 0)

// val f = (num: Long) => prime.filter(_ < sqrt(num)).toArray.par.reverse.filter(num % _ == 0).head

// val f = (n: Long) => {
//   def resolve (n: Long, m: Long): Long =
//     if (n % m == 0 && isPrime(m))
//         return m
//     else
//         return resolve(n, m - 1)
//   resolve(n, sqrt(n).toLong)
// }

// 前にC#で解いた時の方法をやろうとしたら遅かったのでパクってしまいました。コレクションのメソッドが遅延評価じゃないの辛いね。
// http://bach.istc.kobe-u.ac.jp/lect/ProLang/org/euler-003.html

val f = (n: Long) => {
  def factor(n: Long, p: Long): List[Long] =
    if (n < p * p)
      List(n)
    else if (n % p == 0)
      p :: factor(n / p, p)
    else
      factor(n, p + 1)
  factor(n, 2).last
}

println(f(13195))
println(f(600851475143L))
