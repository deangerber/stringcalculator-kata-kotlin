import java.util.regex.Pattern

object StringCalculator {
  fun add(input: String): Int {
    if (input.isEmpty()) return 0
    return when (input.startsWith("//")) {
      true -> sumWithCustomDelimiter(input)
      false -> sumWithKnownDelimiter(input)
    }
  }

  private fun sumWithKnownDelimiter(input: String, delimiter: String = "[,\n]"): Int {
    val numbers = input
        .split(delimiter.toRegex())
        .map { it.toInt() }
        .filter { it <= 1000 }

    val negativeNumbers = numbers.filter { it < 0 }

    return when (negativeNumbers.isEmpty()) {
      true -> numbers.sum()
      false -> throw NegativeNumbersNotAllowedException("Negative numbers not allowed: $negativeNumbers")
    }
  }

  private fun sumWithCustomDelimiter(input: String): Int {
    val pieces = input.split("\n")
    val numbers = pieces.last()
    val delimiter = pieces
        .first()
        .removePrefix("//")
        .removeSurrounding("[", "]")
    return sumWithKnownDelimiter(numbers, Pattern.quote(delimiter))
  }
}
