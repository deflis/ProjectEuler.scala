def diagonals(n: Int):Int = {
  def d: Int => (Int, Int) = {
    case 0 => (1, 1)
    case n => {
      val x = d(n - 1)
      (x._1 + 8 * n, x._2 + 4 * x._1 + 20 * n)
    }
  }
  d((n - 1) / 2)._2
}

println(diagonals(1001))
