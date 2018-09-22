import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StringCalculatorShould {

  @Test
  fun `return 0 when given an empty string`() {
    assertEquals(0, StringCalculator.add(""))
  }

  @Test
  fun `return the int of a number that is passed in as a string`() {
    assertEquals(1, StringCalculator.add("1"))
  }

  @Test
  fun `return the sum of a string of numbers seperated by a comma`() {
    assertEquals(3, StringCalculator.add("1,2"))
  }

  @Test
  fun `return the sum of a string of many numbers seperated by a comma`() {
    assertEquals(10, StringCalculator.add("1,2,3,4"))
  }

  @Test
  fun `return the sum of a string of numbers seperated by a comma and newline`() {
    assertEquals(6, StringCalculator.add("1,2\n3"))
  }

  @Test
  fun `return the sum of a string of numbers seperated by custom delimiter`() {
    assertEquals(6, StringCalculator.add("//;\n1;2;3"))
  }

  @Test
  fun `throw an exception if given a string that contains any negative numbers`() {
    assertFailsWith(NegativeNumbersNotAllowedException::class, "Negative numbers not allowed: -2 -4") { StringCalculator.add("//;\n1;-2;3;-4") }
  }

  @Test
  fun `return the sum of a string of numbers ignoring any numbers over a thousand`() {
    assertEquals(3, StringCalculator.add("//;\n1;2;1001"))
  }

  @Test
  fun `return the sum of a string of numbers seperated by multi length custom delimiter`() {
    assertEquals(6, StringCalculator.add("//[***]\n1***2***3"))
  }

  @Test
  fun `return the sum of a string of numbers seperated by multiple single custom delimiters`() {
    assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"))
  }
}