@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)

package com.jimandreas

import com.jimandreas.entities.AnalyzeTasks
import com.jimandreas.entities.EntityUtilities
import com.jimandreas.solutionSurvey.SimpleSolutionSurvey
import kotlinx.serialization.json.Json
import java.io.File

val pp = PrintUtilities()
val entUtil = EntityUtilities()


fun main() {
    println("touching ${trainingNames.size} training tasks and ${evaluationNames.size} evaluation tasks")
    val t = System.currentTimeMillis()

    for (t in trainingNames) {
        val filePath = "$pathPrefix$trainingPrefix$t.json"
        openIt(filePath)
    }

    for (t in evaluationNames) {
        val filePath = "$pathPrefix$evaluationPrefix$t.json"
        openIt(filePath)
    }

    val endTime = System.currentTimeMillis()
    val elapsed = endTime - t
    println("elapsed time = $elapsed in milliseconds")
}

private fun openIt(name: String) {

    val file = File(name)
    val exists = file.exists()
    val isAFile = file.isFile
    val canRead = file.canRead()

    println(name)

    if (!(exists && isAFile && canRead)) {
        throw Exception("file not found.")
    }

    lateinit var taskData : TaskCoordinateData

    try {
        taskData = Json.decodeFromString<TaskCoordinateData>(file.readText())
    } catch (e: Exception) {
        println("ERROR on json decode on file: $name")
    }

    val analyze = AnalyzeTasks()
    analyze.analyzeTrainingData(taskData)

    val simpleSol = SimpleSolutionSurvey()
    simpleSol.scanForBlockCompletionSolution()

    taskTrainDataList.clear()
    taskTestDataList.clear()
}
