package com.jimandreas

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class TrainingData(
    val train: List<TrainExample>,
    val test: List<TrainExample>
)

@Serializable
data class TrainExample(
    val input: List<List<Int>>,
    val output: List<List<Int>>
)

fun main() {
    var filePath = "C:/a/ARC-AGI/data/training/00d62c1b.json"
    val file = File(filePath)
    val exists =  file.exists()
    val isAFile = file.isFile
    val canRead = file.canRead()

    val foo = exists && isAFile && canRead

    val myData = Json.decodeFromString<TrainingData>(file.readText())

    println("Done\n")
}




