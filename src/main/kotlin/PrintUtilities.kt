package com.jimandreas

class PrintUtilities {

    /**
     * pretty print all problem matrices
     */
    fun prettyPrintProblem(td: TrainingData) {
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
                if (pairIsIn(entity, Pair(row, col)))
                    s.append(" X")
                else {
                    s.append(" ${matrix[row][col]}", )
                }
            }

            println(s)
        }
    }

    private fun pairIsIn(entity: List<Set<Pair<Int, Int>>>, p: Pair<Int, Int> ): Boolean {
        for (e in entity) {
            if (e.contains(p)) {
                return true
            }
        }
        return false
    }
}
