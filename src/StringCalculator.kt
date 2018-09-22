object StringCalculator {
  fun add(input: String): Int {
    if (input.isEmpty()) return 0
    return input.split(",").map { it.toInt() }.sum()
  }
}
