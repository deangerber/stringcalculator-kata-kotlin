object StringCalculator {
  fun add(input: String): Int {
    if (input.isEmpty()) return 0
    return when (input.startsWith("//")) {
      true -> sumWithCustomDelimiter(input)
      false -> sumWithKnownDelimiter(input)
    }
  }

  private fun sumWithKnownDelimiter(input: String, delimiter: String = "[,\n]"): Int {
    return input.split(delimiter.toRegex()).map { it.toInt() }.sum()
  }

  private fun sumWithCustomDelimiter(input: String): Int {
    val pieces = input.split("\n")
    val numbers = pieces.last()
    val delimiter = pieces.first().removePrefix("//")
    return sumWithKnownDelimiter(numbers, delimiter)
  }
}
