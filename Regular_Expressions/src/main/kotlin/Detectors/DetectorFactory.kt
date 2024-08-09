package detectors.Detectors

import Detectors.*
import Validators.*

class DetectorFactory {
    fun createDetector(type: DetectorType): DetectorStrategy {
        return when (type) {
            DetectorType.INTEGER -> IntegerDetectorStrategy(IntegerValidator())
            DetectorType.FLOATING_POINT -> FloatingPointDetectorStrategy(FloatingPointValidator())
            DetectorType.BINARY_NUMBER -> BinaryNumberDetectorStrategy(BinaryNumberValidator())
            DetectorType.EMAIL -> EmailDetectorStrategy(EmailValidator())
            DetectorType.PASSWORD -> PasswordDetectorStrategy(PasswordValidator())
        }
    }
}

enum class DetectorType {
    INTEGER,
    FLOATING_POINT,
    BINARY_NUMBER,
    EMAIL,
    PASSWORD
}
