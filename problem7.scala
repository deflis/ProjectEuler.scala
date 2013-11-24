// 前に書いた 素数生成ルーチン遅すぎた…  http://pavelfatin.com/scala-for-project-euler/

lazy val ps: Stream[Int] = 2 #:: Stream.from(3).filter(i => ps.takeWhile(j => j * j <= i).forall(i % _ > 0))

println( ps(10000))

// lazy val _prime: Stream[Long] = 3 #:: _prime.map(p => ((p + 2) to (p * 2) by 2).par.filter(n => (2 #:: _prime).takeWhile(_ < p).par.forall(n % _ != 0)).head)
// lazy val prime = 2 #:: _prime
// 
//  println(prime(10001))

