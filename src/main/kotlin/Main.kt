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

    val pp = PrintUtilities()

    pp.prettyPrintProblem(myData)


    val entUtil = EntityUtilities()

    val d = myData.train[2].input
    val entities = entUtil.findAllIsolatedEntities(d)

    println("\n")
    pp.prettyPrintOneMatrixWithEntityDesignation(d, entities)
    println("Done\n")
}