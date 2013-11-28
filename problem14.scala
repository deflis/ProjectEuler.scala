val memo = scala.collection.mutable.Map.empty[Long, Long]

val collatz_func = (n: Long) => {
  memo.getOrElseUpdate(n, if (n % 2 == 0) {
    n / 2
  } else {
    3 * n + 1
  })
}

def collatzList (n: Long):Stream[Long] =
  (n #:: collatzList(n).map(collatz_func(_)))

println((1 to 1000000).view.map(n => (n, collatzList(n.toLong).indexWhere(_ == 1))).maxBy(_._2)._1)
