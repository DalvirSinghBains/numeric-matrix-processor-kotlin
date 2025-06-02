package processor

fun transposeMainDiagonal(A: MutableList<MutableList<Double>>): MutableList<MutableList<Double>> {
    val matrix: MutableList<MutableList<Double>> = mutableListOf()

    for (i in 0..<A.first().size) {
        val row: MutableList<Double> = mutableListOf()
        for (j in 0..<A.size) {
            val element = A[j][i]
            row.add(element)
        }
        matrix.add(row)
    }
    return matrix
}

fun transposeSideDiagonal(A: MutableList<MutableList<Double>>): MutableList<MutableList<Double>> {
    val matrix: MutableList<MutableList<Double>> = mutableListOf()

    for (i in A.first().size - 1 downTo 0) {
        val row: MutableList<Double> = mutableListOf()
        for (j in A.size - 1 downTo 0) {
            val element = A[j][i]
            row.add(element)
        }
        matrix.add(row)
    }
    return matrix
}

fun transposeVertical(A: MutableList<MutableList<Double>>): MutableList<MutableList<Double>> {
    val matrix: MutableList<MutableList<Double>> = mutableListOf()

    for (i in 0..<A.size) {
        matrix.add(A[i].reversed().toMutableList())
    }
    return matrix
}

fun transposeHorizontal(A: MutableList<MutableList<Double>>): MutableList<MutableList<Double>> {
    val matrix: MutableList<MutableList<Double>> = mutableListOf()

    for (i in A.first().size - 1 downTo 0) {
        matrix.add(A[i].toMutableList())
    }
    return matrix
}