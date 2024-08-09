package Detectors
import Validators.EmailValidator
import detectors.Detectors.DetectorStrategy

class EmailDetectorStrategy(private val validator: EmailValidator) : DetectorStrategy {
    override fun isValid(input: String): Boolean {
        return validator.isValid(input)
    }
}
