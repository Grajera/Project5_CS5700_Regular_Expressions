import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.FirstStateFactory
import regular_expressions.Verifier

class EmailDetectorStrategyTests {

    val verifier = Verifier()
    val emailState = FirstStateFactory().createFirstState("email")!!

    @Test
    fun testValidEmails() {
        assertTrue(verifier.verify("a@b.c", emailState))                   // Valid
        assertTrue(verifier.verify("joseph.ditton@usu.edu", emailState))   // Valid
        assertTrue(verifier.verify("{}*$.&$*(@*$%&.*&*", emailState))      // Valid
    }

    @Test
    fun testInvalidEmails() {
        assertFalse(verifier.verify("@b.c", emailState))                   // Part 1 is empty
        assertFalse(verifier.verify("a@b@c.com", emailState))              // Too many @ symbols
        assertFalse(verifier.verify("a.b@b.b.c", emailState))              // Too many periods after the @
        assertFalse(verifier.verify("joseph ditton@usu.edu", emailState))  // Space character not allowed
        assertFalse(verifier.verify("a@b.", emailState))                   // Part 3 empty
    }
}
