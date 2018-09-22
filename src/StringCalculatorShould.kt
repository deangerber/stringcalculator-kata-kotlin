import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
}