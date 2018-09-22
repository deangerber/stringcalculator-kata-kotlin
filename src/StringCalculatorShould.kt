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
}