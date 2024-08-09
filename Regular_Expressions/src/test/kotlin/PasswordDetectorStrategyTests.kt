import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class PasswordDetectorStrategyTests {

    val verification = Verification()
    val passwordPointState = StateMachineFactory().crateStateMachine("password")!!

    @Test
    fun testValidPasswords() {
        assertTrue(verification.verify("aaaaH!aa", passwordPointState))                   // Valid
        assertTrue(verification.verify("1234567*9J", passwordPointState))                 // Valid
        assertTrue(verification.verify("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH", passwordPointState)) // Valid
    }

    @Test
    fun testInvalidPasswords() {
        assertFalse(verification.verify("a", passwordPointState))                          // Too short
        assertFalse(verification.verify("aaaaaaa!", passwordPointState))                  // No capital letter and ends with special char
        assertFalse(verification.verify("aaaHaaaaa", passwordPointState))                 // No special char
        assertFalse(verification.verify("Abbbbbbb!", passwordPointState))                 // Ends with special char
    }
}
