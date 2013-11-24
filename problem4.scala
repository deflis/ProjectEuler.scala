
val numbers = 999 to 100 by -1

val product = for(n <- numbers; m <- numbers) yield {
  n * m
}

println(product.filter(p =>
  p.toString.reverse == p.toString
).max)

