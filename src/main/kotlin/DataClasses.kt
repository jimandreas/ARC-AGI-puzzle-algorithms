package com.jimandreas

import kotlinx.serialization.Serializable

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