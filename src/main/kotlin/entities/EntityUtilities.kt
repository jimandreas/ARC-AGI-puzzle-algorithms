@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)
package com.jimandreas.entities

class EntityUtilities {

    /**
     * Please assume kotlin.  A matrix is given in the form of
     * integers in List<List<Int>>.   Therefore it is a two
     * dimensional matrix.  Assume an int with value of zero is
     * a background.  Please write a function that can trace
     * around entries with non-zero values to find an isolated
     * matrix “entity”.  Please create a set of (row, column)
     * pairs that list the coordinates of the isolated entity.
     * The entity should be surrounded by either (1) the edge of
     * the matrix, or (2) values of zero.  Thus this is an isolated
     * form in the matrix.
     *
     * 2nd generation.   That was good.  Now please modify the
     * algorithm so that it finds *all* isolated forms in the matrix.
     * Note that the interior cells of a form do not need to be searched.
     * But the search should continue until all cells *exterior* to the
     * forms should be searched.  It should return a List of Sets of Pairs.
     *
     */
    fun findAllIsolatedEntities(matrix: List<List<Int>>): List<Set<Pair<Int, Int>>> {
        val allEntities = mutableListOf<Set<Pair<Int, Int>>>()
        val numRows = matrix.size
        val numCols = matrix[0].size
        val visited = mutableSetOf<Pair<Int, Int>>() // Keep track of visited cells

        fun isBoundary(row: Int, col: Int): Boolean {
            return row == 0 || row == numRows - 1 || col == 0 || col == numCols - 1
        }

        fun exploreEntity(row: Int, col: Int): Set<Pair<Int, Int>> {
            val entityCoordinates = mutableSetOf<Pair<Int, Int>>()
            if (row in 0 until numRows && col in 0 until numCols && matrix[row][col] != 0 && Pair(row, col) !in visited) {
                entityCoordinates.add(Pair(row, col))
                visited.add(Pair(row, col))
                exploreEntity(row + 1, col).let { entityCoordinates.addAll(it) }
                exploreEntity(row - 1, col).let { entityCoordinates.addAll(it) }
                exploreEntity(row, col + 1).let { entityCoordinates.addAll(it) }
                exploreEntity(row, col - 1).let { entityCoordinates.addAll(it) }
            }
            return entityCoordinates
        }

        fun neighborsAreZero(matrix: List<List<Int>>, row: Int, col: Int): Boolean {
            return (row - 1 < 0 || matrix[row - 1][col] == 0) &&
                    (row + 1 >= numRows || matrix[row + 1][col] == 0) &&
                    (col - 1 < 0 || matrix[row][col - 1] == 0) &&
                    (col + 1 >= numCols || matrix[row][col + 1] == 0)
        }

        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                if (matrix[row][col] != 0 && Pair(row, col) !in visited && (isBoundary(row, col) || neighborsAreZero(matrix, row, col))) {
                    allEntities.add(exploreEntity(row, col))
                }
            }
        }

        return allEntities
    }


    /*Use code with caution.

    Changes:

    visited set: A visited set is added to keep track of the cells that have already been explored, preventing infinite loops and redundant searches.
    exploreEntity return value: The exploreEntity function now returns a Set<Pair<Int, Int>> containing the coordinates of the entity it explored.
    Storing all entities: The main loop now adds each found entity to the allEntities list.
    Checking visited: The main loop also checks if a cell has been visited before exploring it.
    Example Usage:

    Kotlin
    fun main() {
        val matrix = listOf(
            listOf(0, 0, 0, 0, 0),
            listOf(0, 1, 1, 0, 0),
            listOf(0, 1, 1, 0, 0),
            listOf(0, 0, 0, 2, 2),
            listOf(0, 0, 0, 0, 0)
        )

        val allIsolatedEntities = findAllIsolatedEntities(matrix)
        println(allIsolatedEntities)
        // Expected output: [[(1, 1), (1, 2), (2, 1), (2, 2)], [(3, 3), (3, 4)]]
    }*/

    /**
     * code generated by Google Gemini in response to this prompt:
     * Please assume kotlin.  A matrix is given in the form of integers
     * in List<List<Int>>.   Therefore it is a two dimensional matrix.
     * Assume an int with value of zero is a background.  Please write a
     * function that can trace around entries with non-zero values to find
     * an isolated matrix “entity”.  Please create a set of (row, column)
     * pairs that list the coordinates of the isolated entity.
     * The entity should be surrounded by either (1) the edge of the matrix,
     * or (2) values of zero.  Thus this is an isolated form in the matrix.
     */
    fun findIsolatedEntity(matrix: List<List<Int>>): Set<Pair<Int, Int>> {
        val entityCoordinates = mutableSetOf<Pair<Int, Int>>()
        val numRows = matrix.size
        val numCols = matrix[0].size

        fun isBoundary(row: Int, col: Int): Boolean {
            return row == 0 || row == numRows - 1 || col == 0 || col == numCols - 1
        }

        fun exploreEntity(row: Int, col: Int) {
            if (row in 0 until numRows && col in 0 until numCols && matrix[row][col] != 0 && Pair(row, col) !in entityCoordinates) {
                entityCoordinates.add(Pair(row, col))
                exploreEntity(row + 1, col)
                exploreEntity(row - 1, col)
                exploreEntity(row, col + 1)
                exploreEntity(row, col - 1)
            }
        }

        fun neighborsAreZero(matrix: List<List<Int>>, row: Int, col: Int): Boolean {
            val numRows2 = matrix.size
            val numCols2 = matrix[0].size
            return (row - 1 < 0 || matrix[row - 1][col] == 0) &&
                    (row + 1 >= numRows2 || matrix[row + 1][col] == 0) &&
                    (col - 1 < 0 || matrix[row][col - 1] == 0) &&
                    (col + 1 >= numCols2 || matrix[row][col + 1] == 0)
        }

        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                if (matrix[row][col] != 0 && (isBoundary(row, col) || neighborsAreZero(matrix, row, col))) {
                    exploreEntity(row, col)
                    return entityCoordinates // Assuming only one isolated entity
                }
            }
        }

        return entityCoordinates // Return empty set if no entity is found
    }



    /*
    Use code with caution.

    Explanation:

    findIsolatedEntity(matrix) function:

    Takes the matrix (List<List<Int>>) as input.
    Creates a mutableSetOf<Pair<Int, Int>> to store the coordinates of the isolated entity.
    Gets the number of rows and columns from the matrix.
    isBoundary(row, col) function:

    Checks if a given cell (row, col) is on the boundary of the matrix.
    neighborsAreZero(matrix, row, col) function:

    Checks if all the immediate neighbors (up, down, left, right) of a given cell are zero.
    exploreEntity(row, col) function (recursive):

    This is a recursive function that explores the connected non-zero cells to find the complete entity.
    It takes the current cell's row and column as input.
    It checks if the cell is within bounds, has a non-zero value, and hasn't been visited before.
    If all conditions are true, it adds the cell's coordinates to the entityCoordinates set and recursively calls itself for the neighboring cells.
    Main loop in findIsolatedEntity:

    Iterates through each cell in the matrix.
    If a cell has a non-zero value and is either on the boundary or surrounded by zeros, it calls exploreEntity to start exploring the entity from that cell.
    Returns the entityCoordinates set, which contains the coordinates of the isolated entity.
    Example Usage:

    Kotlin
    fun main() {
        val matrix = listOf(
            listOf(0, 0, 0, 0, 0),
            listOf(0, 1, 1, 0, 0),
            listOf(0, 1, 1, 0, 0),
            listOf(0, 0, 0, 2, 2),
            listOf(0, 0, 0, 0, 0)
        )

        val isolatedEntity = findIsolatedEntity(matrix)
        println(isolatedEntity)
        // Expected output: [(1, 1), (1, 2), (2, 1), (2, 2)]
    }

     */

}