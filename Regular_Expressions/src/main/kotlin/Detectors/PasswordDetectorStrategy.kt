package Detectors

import detectors.Detectors.DetectorStrategy
import Validators.ValidationStrategy

class PasswordDetectorStrategy(private val validator: ValidationStrategy) : DetectorStrategy {
    override fun isValid(input: String): Boolean {
        return validator.isValid(input)
    }
}
