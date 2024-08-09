package detectors.Detectors

interface DetectorStrategy {
    fun isValid(input: String): Boolean
}
