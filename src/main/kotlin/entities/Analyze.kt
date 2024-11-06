@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)
package com.jimandreas.entities

import com.jimandreas.BlockInfo
import com.jimandreas.DataForOneTrainInstance
import com.jimandreas.PrintUtilities
import com.jimandreas.TaskCoordinateData

class Analyze {
    val pp = PrintUtilities()
    val blockUtil = BlockUtilities()
    val blockCompletion = BlockCompletion()

    /*
     * for one training instance input - assemble block info
     *  and whether the blocks are rectangular and coordinates are
     *  missing to make the block a fully rectangular block
     */
    fun analyzeTrainInstance(oneTrainInstance: DataForOneTrainInstance) {
        val blocks = blockUtil.findRectangularBlocks(oneTrainInstance.input)

        pp.prettyPrintOneMatrixWithEntityDesignation(oneTrainInstance.input, blocks)

        oneTrainInstance.blocks = blocks
        val bIter = blocks.iterator().withIndex()

        while (bIter.hasNext()) {
            val bData = bIter.next()
            val setOfPairs = bData.value
            val validFlag = blockUtil.verifyRectangularBlock(setOfPairs)

            println("valid block: $validFlag")

            val isHollow = blockUtil.isBlockHollow(oneTrainInstance.input, setOfPairs)

            println("hollow: $isHollow")

            val completionSet = blockCompletion.completeRectangularBlock(setOfPairs)

            println(completionSet)

            val bi = BlockInfo(coords = setOfPairs,
                rectangularBlockFlag = validFlag,
                hollowFlag = isHollow,
                missingCoordinates = completionSet)
            oneTrainInstance.blockInfo = bi

            pp.prettyPrintBlockInfo(bi)
        }
    }
}