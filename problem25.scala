val memo = scala.collection.mutable.WeakHashMap.empty[Int, BigInt]
def fibonacchi(n: Int):BigInt = memo.getOrElseUpdate(n, if (n <= 2) BigInt(1) else fibonacchi(n - 1) + fibonacchi(n - 2))

lazy val fib = Stream.from(1).map(n => n -> fibonacchi(n))
println(fib.find(_._2.toString.length == 1000).get._1)

