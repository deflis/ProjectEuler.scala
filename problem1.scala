val result = (1 to (1000 - 1)).filter( n => n % 3 == 0 || n % 5 == 0 ).sum

println(result)
