val memo = scala.collection.mutable.WeakHashMap.empty[Tuple2[Int, Int], Long]

def grid (x: Int, y: Int): Long = {
  def f(x: Int, y: Int) = {
    if (x <= 0 || y <= 0) {
      1
    } else {
      grid(x - 1, y) + grid(x, y - 1)
    }
  }
  memo.getOrElseUpdate((x, y), f(x, y))
}

println(grid(20,20))
