package com.jimandreas

import kotlinx.serialization.Serializable

/*
 * comments on the JSON format:
 *    There is only ONE input/output pair for the test part of TrainingData.
 *    That is to say - there is only one "test" with one input and one expected output.
 */
@Serializable
data class TaskCoordinateData(
    val train: List<MatrixDataAsListOfLists>,
    val test: List<MatrixDataAsListOfLists>,   // note that there sometimes MORE THAN ONE entry in this list!!
    val name: String = ""
)

@Serializable
data class MatrixDataAsListOfLists(
    val input: List<List<Int>>,
    val output: List<List<Int>>
)