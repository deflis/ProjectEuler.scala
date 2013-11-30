def isLeapYear (year: Int) = ( year % 4 ) == 0 && ( year % 100 ) != 0 || ( year % 400 ) == 0

val startDayOfMonth: (Int) => (Int) => Int = year => month => month match {
  case 1 => if (year == 1900) 1 else ((startDayOfMonth(year - 1)(12) + 31) % 7)
  case 3 => (startDayOfMonth(year)(2) + (if (isLeapYear(year)) 29 else 28)) % 7
  case m if m == 5 || m == 7 || m == 10 || m == 12 => (startDayOfMonth(year)(m - 1) + 30) % 7
  case m => (startDayOfMonth(year)(m - 1) + 31) % 7
}

println((1901 to 2000).map(y => (1 to 12).map(startDayOfMonth(y)).count(_ == 0)).sum)
