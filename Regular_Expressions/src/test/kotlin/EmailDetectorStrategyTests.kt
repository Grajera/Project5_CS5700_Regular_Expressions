import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class EmailDetectorStrategyTests {

    val verification = Verification()
    val emailState = StateMachineFactory().crateStateMachine("email")!!

    @Test
    fun testValidEmails() {
        assertTrue(verification.verify("a@b.c", emailState))                   // Valid
        assertTrue(verification.verify("joseph.ditton@usu.edu", emailState))   // Valid
        assertTrue(verification.verify("{}*$.&$*(@*$%&.*&*", emailState))      // Valid
    }

    @Test
    fun testInvalidEmails() {
        assertFalse(verification.verify("@b.c", emailState))                   // Part 1 is empty
        assertFalse(verification.verify("a@b@c.com", emailState))              // Too many @ symbols
        assertFalse(verification.verify("a.b@b.b.c", emailState))              // Too many periods after the @
        assertFalse(verification.verify("joseph ditton@usu.edu", emailState))  // Space character not allowed
        assertFalse(verification.verify("a@b.", emailState))                   // Part 3 empty
    }
}
