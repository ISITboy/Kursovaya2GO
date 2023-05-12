package dataGraph

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class ReadTextFile {
    private val file1 = File("C:\\JavaProject\\Kursovaya2GO\\src\\main\\kotlin\\dataGraph\\graphData1.txt")
    private val file2 = File("C:\\JavaProject\\Kursovaya2GO\\src\\main\\kotlin\\dataGraph\\graphData2.txt")

    var textData1 : String=""
    var textData2 : String=""
    init {
        textData1 = readText(file1)
        textData2 = readText(file2)
    }

    private fun readText(file:File):String {
        var result=""
        try {
            BufferedReader(FileReader(file)).use { br ->
                br.lines().forEach { result+=it+"\n" }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }

}