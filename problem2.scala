// 参考 http://blog.livedoor.jp/sylc/archives/1557536.html
lazy val fib: Stream[Int] = 1 #:: 2 #:: fib.zip(fib.tail).map(p => p._1 + p._2)

val r = fib.takeWhile(_ < 4000000).filter(_ % 2 == 0).sum

println(r)
