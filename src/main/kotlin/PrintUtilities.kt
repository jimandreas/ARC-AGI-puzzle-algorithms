@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)
package com.jimandreas

class PrintUtilities {
    var debug = false

    /**
     * pretty print all problem matrices
     */
    fun prettyPrintProblem(td: TaskCoordinateData) {
        if (!debug) {
            return
        }
        val iter = td.train.iterator().withIndex()

        for (t in td.train) {
            val nextTrainingArray = iter.next()
            println(nextTrainingArray.index)

            val te = nextTrainingArray.value
            val rowInputIter = te.input.iterator()
            val rowOutputIter = te.output.iterator()

            while (rowInputIter.hasNext()) {
                val s = StringBuilder()
                val rIn = rowInputIter.next()
                val rOut = rowOutputIter.next()
                val str = StringBuilder()
                s.append(rIn.joinToString(" "))
                s.append(" | ")
                s.append(rOut.joinToString(" "))
                println(s)
            }
        }
    }

    /**
     * pretty print one matrix with "*" for items found in an entity in 2nd copy online
     */
    fun prettyPrintOneMatrixWithEntityDesignation(matrix: List<List<Int>>, entity: List<Set<Pair<Int, Int>>>) {

        if (!debug) {
            return
        }
        val rowInputIter = matrix.iterator().withIndex()

        while (rowInputIter.hasNext()) {
            val s = StringBuilder()
            val rIn = rowInputIter.next()

            s.append(rIn.value.joinToString(" "))
            s.append(" | ")

            val allEntities = mutableListOf<Set<Pair<Int, Int>>>()
            val row = rIn.index
//            val numRows = matrix.size
            val numCols = matrix[0].size


            for (col in 0 until numCols) {
                val setNumber = pairIsIn(entity, Pair(row, col))
                if (setNumber >= 0) {
                    val letter = ('A' + setNumber)
                    s.append(" $letter")
                } else {
//                    s.append(" ${matrix[row][col]}", )
                    s.append("  ",)
                }
            }

            println(s)
        }
    }

    private fun pairIsIn(entity: List<Set<Pair<Int, Int>>>, p: Pair<Int, Int>): Int {
        val eIter = entity.iterator().withIndex()
        while (eIter.hasNext()) {
            val e = eIter.next()
            if (e.value.contains(p)) {
                return e.index
            }
        }
        return -1
    }


    /**
     * print block info with "B" for block entries coords, and an "M" for missing entries in the block
     */
    fun prettyPrintBlockInfo(b: BlockInfo) {
        if (!debug) {
            return
        }
        val maxRow = b.coords.maxOf { it.first }
        val maxCol = b.coords.maxOf { it.second }

        for (r in 0..maxRow) {
            val str = StringBuilder()
            for (c in 0..maxCol) {
                if (b.coords.contains(Pair(r, c))) {
                    str.append(" B")
                } else {
                    if (b.missingCoordinates.contains(Pair(r, c))) {
                        str.append(" M")
                    } else {
                        str.append(" .")
                    }
                }
            }
            println(str.toString())
        }
    }


}