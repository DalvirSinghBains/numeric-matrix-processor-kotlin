package processor

fun addMatrices(
    A: MutableList<MutableList<Double>>,
    B: MutableList<MutableList<Double>>
): MutableList<MutableList<Double>> {
    val matrix: MutableList<MutableList<Double>> = mutableListOf()

    for (i in 0..<A.size) {
        val tempMatrix: MutableList<Double> = mutableListOf()
        for (j in 0..<A.first().size) {
            tempMatrix.add((A[i][j] + B[i][j]))
        }
        matrix.add(tempMatrix)
    }
    return matrix
}
