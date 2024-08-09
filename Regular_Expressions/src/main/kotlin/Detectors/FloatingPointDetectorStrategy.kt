package Detectors

import detectors.Detectors.DetectorStrategy
import Validators.ValidationStrategy

class FloatingPointDetectorStrategy(private val validator: ValidationStrategy) : DetectorStrategy {
    override fun isValid(input: String): Boolean {
        return validator.isValid(input)
    }
}
