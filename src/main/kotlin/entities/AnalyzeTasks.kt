@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)
package com.jimandreas.entities

import com.jimandreas.*

class AnalyzeTasks {
    val pp = PrintUtilities()
    val blockUtil = BlockUtilities()
    val blockCompletion = BlockCompletion()

    // results are accumulated in taskTrainingDataList

    fun analyzeTrainingData(td: TaskCoordinateData) {

        // first assemble the training input and output data into the taskTrainDataList
        for (i in 0 until td.train.size) {

            val mdata = td.train[i]
            val dataForOneExampleInput = DataForOneTrainExample()
            dataForOneExampleInput.matrix = mdata.input

            val dataForOneExampleOutput = DataForOneTrainExample()
            dataForOneExampleOutput.matrix = mdata.output

            val dio = DataInputOutput(
                dataForOneExampleInput, dataForOneExampleOutput
            )
            taskTrainDataList.add(dio)
        }

        // now characterize each input and each output

        for (trainExample in taskTrainDataList) {
            analyzeTrainingInputOrOutput(trainExample.input)
            analyzeTrainingInputOrOutput(trainExample.output)
        }
    }

    /*
     * for one training input or output
     */
    fun analyzeTrainingInputOrOutput(oneTrainInstance: DataForOneTrainExample) {
        val matrix = oneTrainInstance.matrix
        val blocks = blockUtil.findRectangularBlocks(matrix)

        pp.prettyPrintOneMatrixWithEntityDesignation(matrix, blocks)

        oneTrainInstance.blocks = blocks
        val bIter = blocks.iterator().withIndex()

        while (bIter.hasNext()) {
            val bData = bIter.next()
            val setOfPairs = bData.value
            val validFlag = blockUtil.verifyRectangularBlock(setOfPairs)

            //println("valid block: $validFlag")

            val isHollow = blockUtil.isBlockHollow(matrix, setOfPairs)

            //println("hollow: $isHollow")

            val completionSet = blockCompletion.completeRectangularBlock(setOfPairs)

            //println(completionSet)

            val bi = BlockInfo(coords = setOfPairs,
                rectangularBlockFlag = validFlag,
                hollowFlag = isHollow,
                missingCoordinates = completionSet)
            oneTrainInstance.blockInfoList.add(bi)

            pp.prettyPrintBlockInfo(bi)
        }
    }
}