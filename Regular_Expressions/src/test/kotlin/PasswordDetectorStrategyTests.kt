import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.FirstStateFactory
import regular_expressions.Verifier

class PasswordDetectorStrategyTests {

    val verifier = Verifier()
    val passwordPointState = FirstStateFactory().createFirstState("password")!!

    @Test
    fun testValidPasswords() {
        assertTrue(verifier.verify("aaaaH!aa", passwordPointState))                   // Valid
        assertTrue(verifier.verify("1234567*9J", passwordPointState))                 // Valid
        assertTrue(verifier.verify("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH", passwordPointState)) // Valid
    }

    @Test
    fun testInvalidPasswords() {
        assertFalse(verifier.verify("a", passwordPointState))                          // Too short
        assertFalse(verifier.verify("aaaaaaa!", passwordPointState))                  // No capital letter and ends with special char
        assertFalse(verifier.verify("aaaHaaaaa", passwordPointState))                 // No special char
        assertFalse(verifier.verify("Abbbbbbb!", passwordPointState))                 // Ends with special char
    }
}
