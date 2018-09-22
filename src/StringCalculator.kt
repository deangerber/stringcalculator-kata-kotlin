object StringCalculator {
  fun add(input: String): Int {
    if (input.isEmpty()) return 0
    return when (input.startsWith("//")) {
      true -> sumWithCustomDelimiter(input)
      false -> input.split("[,\n]".toRegex()).map { it.toInt() }.sum()
    }
  }

  fun sumWithCustomDelimiter(input: String): Int {
    val pieces = input.split("\n")
    val numbers = pieces.last()
    val delimiter = pieces.first().removePrefix("//")
    return numbers.split(delimiter.toRegex()).map { it.toInt() }.sum()
  }
}
