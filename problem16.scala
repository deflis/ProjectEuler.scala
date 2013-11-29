println((BigInt(1) to 1000).fold(BigInt(1))((n, m) => n * 2).toString.map(_.asDigit).sum)
