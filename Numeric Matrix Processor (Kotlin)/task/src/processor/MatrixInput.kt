package processor

fun displayMatrix(matrix: MutableList<MutableList<Double>>) {
    println("The result is:")
    for (i in 0..<matrix.size) {
        println(matrix[i].joinToString(" "))
    }
}

fun readMatrix(x: MutableList<Int>): MutableList<MutableList<Double>> {
    val matrix: MutableList<MutableList<Double>> = mutableListOf()
    for (i in 0..<x.first()) {
        val row = readln()
            .split(" ")
            .map { it.toDouble() }
            .toMutableList()
        matrix.add(row)
    }
    return matrix
}

fun readDimensions() = readln().trim()
    .split(" ")
    .map { it.toInt() }
    .toMutableList()

fun readTransposeUserInputs(choice: Int): MutableList<MutableList<Double>> {
    println("Your choice: $choice")
    println("Enter matrix size:")
    val dimensions = readDimensions()
    println("Enter matrix:")
    val matrix = readMatrix(dimensions)
    return matrix
}