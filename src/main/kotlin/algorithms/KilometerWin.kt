package algorithms

import java.math.RoundingMode
import java.text.DecimalFormat

class KilometerWin(masSm: Array<Array<Double>>) {

    private val masSm = masSm
    private val matrixKmWin : Array<Array<Double>>
    init {
        matrixKmWin = algo()
        putNullArrayKmWin()
    }

    private fun algo():Array<Array<Double>>{
        var curArray: Array<Array<Double>>  =  Array(masSm.size) { Array(masSm.size) { 0.0 } }
        for(i in masSm.indices){
            for (j in 0 until masSm[i].size){
                var result = masSm[0][i]+masSm[0][j]-masSm[i][j]
                curArray[i][j] = formattingNumber(result)
            }
        }
        return curArray
    }

    private fun formattingNumber(number: Double) : Double =
        number.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()



    private fun putNullArrayKmWin(){
        for(i in 0 until matrixKmWin.size){
            matrixKmWin[i][i]=0.0
        }
    }


    fun returnMatrixKmWin():Array<Array<Double>> = matrixKmWin
}