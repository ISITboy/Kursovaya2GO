package algorithms

import java.math.RoundingMode

class FloydsAlgorithm (matrixRout:String){
    private val masSm: Array<Array<Double>>
    init {
        masSm = makeMatrixFromDataGraph(matrixRout)
        algo()
    }
    private fun algo(){
        for (k in masSm.indices) {
            for (i in masSm.indices) {
                for (j in masSm.indices) {
                    if((masSm[i][j]> masSm[i][k]+masSm[k][j])&&masSm[i][k]<Int.MAX_VALUE&&masSm[k][j]<Int.MAX_VALUE){
                        masSm[i][j] = formattingNumber(masSm[i][k]+masSm[k][j])
                    }
                }
            }
        }
    }

    // ф-я для преобразования массива, который нам поступил в graphData.txt
    private fun makeMatrixFromDataGraph(matrixText: String): Array<Array<Double>> {
        val n = matrixText.lines().count() - 1  //кол-во вершин
        val matrixRout: Array<Array<Double>> = Array(n) { Array(n) { Int.MAX_VALUE.toDouble() } }
        val lines = matrixText.lines()
        var iterator = 0
        lines.forEach {
            val numbers = Regex("[0.0-9.0]+").findAll(it)//создает лист numbers с числами дабл
                .map(MatchResult::value)
                .toList()
            for (i in numbers.indices) {    //цикл для заполнения массива
                if (numbers[i] != "999.0")
                    matrixRout[iterator][i] = numbers[i].toDouble()
            }
            iterator++

        }
        return matrixRout
    }


    private fun formattingNumber(number: Double) : Double =
        number.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()

    fun returnMasSm():Array<Array<Double>> = masSm

}