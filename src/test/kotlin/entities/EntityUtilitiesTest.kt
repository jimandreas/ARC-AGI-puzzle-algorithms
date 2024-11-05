@file:Suppress(
    "UNUSED_VARIABLE", "MemberVisibilityCanBePrivate", "unused",
    "ReplaceManualRangeWithIndicesCalls", "ReplaceSizeZeroCheckWithIsEmpty",
    "SameParameterValue", "UnnecessaryVariable"
)

import com.jimandreas.*
import com.jimandreas.entities.EntityUtilities
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

internal class EntityUtilitiesTest {

    val pp = PrintUtilities()
    val entUtil = EntityUtilities()

    @BeforeEach
    fun setUp() {
        // do something
    }

    @Test
    @DisplayName("count entities in all tasks")
    fun countEntitiesInAllTasks() {
        println("touching ${trainingNames.size} training tasks and ${evaluationNames.size} evaluation tasks")
        for (t in trainingNames) {
            val filePath = "$pathPrefix$trainingPrefix$t.json"
            openIt(filePath)
        }

        for (t in evaluationNames) {
            val filePath = "$pathPrefix$evaluationPrefix$t.json"
            openIt(filePath)
        }
    }

    private fun openIt(name: String) {

        val file = File(name)
        val exists = file.exists()
        val isAFile = file.isFile
        val canRead = file.canRead()

        if (!(exists && isAFile && canRead)) {
            throw Exception("file not found.")
        }

        lateinit var myData : TrainingData

        try {
            myData = Json.decodeFromString<TrainingData>(file.readText())
        } catch (e: Exception) {
            println("ERROR on json decode on file: $name")
        }

        if (myData.test.size != 1) {
            println("$name")
        }
        //pp.prettyPrintProblem(myData)

        for (d in myData.train) {
            val entities = entUtil.findAllIsolatedEntities(d.input)
//            println("$name ${entities.size}")
        }

//        println("\n")
//        pp.prettyPrintOneMatrixWithEntityDesignation(d, entities)
//        println("Done\n")
    }
}