import scala.language.postfixOps

implicit class FactBigInt(val n : BigInt) {
  def ! : BigInt = (BigInt(1) to n).product
}

println((BigInt(100)!).toString.map(_.asDigit).sum)
