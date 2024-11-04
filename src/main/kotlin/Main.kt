@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)

package com.jimandreas

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
//    var filePath = "C:/a/ARC-AGI/data/training/00d62c1b.json"
    val filePath = "C:/a/ARC-AGI/data/evaluation/00dbd492.json"
    val file = File(filePath)
    val exists =  file.exists()
    val isAFile = file.isFile
    val canRead = file.canRead()

    val foo = exists && isAFile && canRead

    val myData = Json.decodeFromString<TrainingData>(file.readText())

    prettyPrintProblem(myData)

    println("Done\n")
}

/**
 * first iteration on pretty printing a problem matrix
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