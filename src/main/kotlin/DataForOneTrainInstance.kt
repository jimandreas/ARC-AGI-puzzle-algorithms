package com.jimandreas

data class BlockInfo(
    val coords: Set<Pair<Int, Int>>,
    val rectangularBlockFlag: Boolean,
    val hollowFlag: Boolean,
    val missingCoordinates: Set<Pair<Int, Int>>
)

class DataForOneTrainInstance {
    var input: List<List<Int>> = emptyList()
    var output: List<List<Int>> = emptyList()

    var blocks: List<Set<Pair<Int, Int>>> = emptyList()
    var isolatedThings: List<List<Set<Pair<Int, Int>>>> = emptyList()

    lateinit var blockInfo : BlockInfo
}