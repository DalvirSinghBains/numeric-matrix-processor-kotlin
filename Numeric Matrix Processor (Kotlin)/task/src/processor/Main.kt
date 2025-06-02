package processor

fun main() {
    displayMenu()
}

private fun displayMenu() {
    while (true) {
        val welcomeString = """
        1. Add matrices
        2. Multiply matrix by a constant
        3. Multiply matrices
        4. Transpose matrix
        5. Calculate a determinant
        6. Inverse matrix
        0. Exit
    """.trimIndent()
        println(welcomeString)
        when (val choice = readln().toInt()) {
            1 -> {
                println("Your choice: $choice")
                println("Enter size of first matrix:")
                val dimA = readDimensions()
                println("Enter first matrix:")
                val A = readMatrix(dimA)
                println("Enter size of second matrix:")
                val dimB = readDimensions()
                println("Enter second matrix:")
                val B = readMatrix(dimB)
                if ((dimA.first() == dimB.first()) && (dimA.last() == dimB.last())) {
                    val sum = addMatrices(A, B)
                    displayMatrix(sum)
                } else {
                    println("The operation cannot be performed.")
                }
            }

            2 -> {
                println("Your choice: $choice")
                println("Enter size of matrix:")
                val dimensions = readDimensions()
                println("Enter matrix:")
                val matrix = readMatrix(dimensions)
                println("Enter constant:")
                val constant = readln().toDouble()
                val scaled = multiplyByConstant(constant, matrix)
                displayMatrix(scaled)
            }

            3 -> {
                println("Your choice: $choice")
                println("Enter size of first matrix:")
                val dimA = readDimensions()
                println("Enter first matrix:")
                val A = readMatrix(dimA)
                println("Enter size of second matrix:")
                val dimB = readDimensions()
                println("Enter second matrix:")
                val B = readMatrix(dimB)
                // check constraints
                if ((dimA.last() == dimB.first())) {
                    val multiplied = multiplyMatrices(A, B)
                    displayMatrix(multiplied)
                } else {
                    println("The operation cannot be performed.")
                }
            }

            4 -> {
                println("Your choice: $choice")
                transposeMenu()
            }

            5 -> {
                println("Your choice: $choice")
                println("Enter matrix size:")
                val dimensions = readDimensions()
                println("Enter matrix:")
                val matrix = readMatrix(dimensions)
                if (dimensions.first() == dimensions.last()) {
                    val determinant = findDeterminant(matrix)
                    println("The result is:")
                    println(determinant)
                } else {
                    println("The operation cannot be performed.")
                }
            }

            6 -> {
                println("Your choice: $choice")
                println("Enter matrix size:")
                val dimensions = readDimensions()
                println("Enter matrix:")
                val matrix = readMatrix(dimensions)
                if (dimensions.first() == dimensions.last()) {
                    val determinant = findDeterminant(matrix)
                    if (determinant == 0.0) {
                        println("This matrix doesn't have an inverse.")
                    } else {
                        // do calculations and print result
                        val scalar = (1 / determinant)
                        val coFactorMatrix = coFactorMatrix(matrix)
                        val transposedCofactorMatrix = transposeMainDiagonal(coFactorMatrix)
                        val inverseMatrix = multiplyByConstant(scalar, transposedCofactorMatrix)
                        displayMatrix(inverseMatrix)
                    }
                } else {
                    println("The operation cannot be performed.")
                }
            }

            0 -> {
                break
            }

            else -> println("Invalid choice")
        }
    }
}

private fun transposeMenu() {
    val welcomeString = """
        1. Main diagonal
        2. Side diagonal
        3. Vertical line
        4. Horizontal line
        0. Exit
    """.trimIndent()
    println(welcomeString)
    when (val choice = readln().toInt()) {
        1 -> {
            val matrix = readTransposeUserInputs(choice)
            displayMatrix(transposeMainDiagonal(matrix))
        }

        2 -> {
            val matrix = readTransposeUserInputs(choice)
            displayMatrix(transposeSideDiagonal(matrix))
        }

        3 -> {
            val matrix = readTransposeUserInputs(choice)
            displayMatrix(transposeVertical(matrix))
        }

        4 -> {
            val matrix = readTransposeUserInputs(choice)
            displayMatrix(transposeHorizontal(matrix))
        }

        else -> println("Invalid choice")
    }
}

