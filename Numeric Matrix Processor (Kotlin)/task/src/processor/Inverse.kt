package processor

import kotlin.math.pow
import kotlin.math.roundToInt

fun coFactorMatrix(matrix: MutableList<MutableList<Double>>): MutableList<MutableList<Double>> {
    val coFactorMatrix: MutableList<MutableList<Double>> = mutableListOf()

    for (i in 0..<matrix.size) {
        val row: MutableList<Double> = mutableListOf()
        for (j in 0..<matrix.size) {
            val subMatrix = matrix.filterIndexed { index, _ -> index != i }
                .map { elem -> elem.filterIndexed { index, _ -> index != j }.toMutableList() }
                .toMutableList()
            val multiplier = ((-1.0).pow(i + j + 2)).roundToInt()
            val minor = findDeterminant(subMatrix)
            val cofactor = multiplier * minor
            row.add(cofactor)
        }
        coFactorMatrix.add(row)
    }
    return coFactorMatrix
}
