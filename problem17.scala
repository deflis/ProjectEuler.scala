val units = Array(0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8)

val tens = Array(0, 0, 6, 6, 5, 5, 5, 7, 6, 6)

lazy val numberToEnglishWordsCount: Int => Int = {
  case 1000 => 11
  case n if (n >= 100) => numberToEnglishWordsCount(n / 100) + 7 + (if (n % 100 > 0) 3 + numberToEnglishWordsCount(n  % 100) else 0)
  case n if (n >= 20) => tens(n/10) + numberToEnglishWordsCount(n % 10)
  case n if (n > 0) => units(n)
  case 0 => 0
}

println((1 to 1000).map(numberToEnglishWordsCount).sum)
