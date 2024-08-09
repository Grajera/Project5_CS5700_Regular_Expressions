import detectors.Detectors.DetectorFactory
import detectors.Detectors.DetectorType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EmailDetectorStrategyTests {

    private val factory = DetectorFactory()

    @Test
    fun testValidEmails() {
        val emailDetector = factory.createDetector(DetectorType.EMAIL)
        assertTrue(emailDetector.isValid("a@b.c"))                   // Valid
        assertTrue(emailDetector.isValid("joseph.ditton@usu.edu"))   // Valid
        assertTrue(emailDetector.isValid("{}*$.&$*(@*$%&.*&*"))      // Valid
    }

    @Test
    fun testInvalidEmails() {
        val emailDetector = factory.createDetector(DetectorType.EMAIL)
        assertFalse(emailDetector.isValid("@b.c"))                   // Part 1 is empty
        assertFalse(emailDetector.isValid("a@b@c.com"))              // Too many @ symbols
        assertFalse(emailDetector.isValid("a.b@b.b.c"))              // Too many periods after the @
        assertFalse(emailDetector.isValid("joseph ditton@usu.edu"))  // Space character not allowed
        assertFalse(emailDetector.isValid("a@.c"))                   // Part 2 empty
        assertFalse(emailDetector.isValid("a@b."))                   // Part 3 empty
    }
}
