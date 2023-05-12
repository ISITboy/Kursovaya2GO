import algorithms.ClarkeRightAlgorithm
import algorithms.FloydsAlgorithm
import algorithms.KilometerWin

class CheckReight {




    init{

        val tableGO1=Array(13, { Array(13, {0.0}) })
        tableGO1[0] = arrayOf(0.0,7.0,4.0,12.37,5.10,12.04,7.28,6.08,14.76,7.28,5.0,9.22,7.28)
        tableGO1[1] = arrayOf(7.0,0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO1[2] = arrayOf(4.0,11.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO1[3] = arrayOf(12.37,12.65, 13.89, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO1[4] = arrayOf(5.10,9.43, 5.83, 17.46, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO1[5] = arrayOf(12.04,8.25,15.26,7.21,16.40,0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0)
        tableGO1[6] = arrayOf(7.28,11.40,7.28,7.07,12.04,11.05,0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0)
        tableGO1[7] = arrayOf(6.08,13.04,2.24,14.21,7.81,16.55,7.21,0.0, 0.0, 0.0,0.0, 0.0, 0.0)
        tableGO1[8] = arrayOf(14.76,13.0,17.03,4.12,19.70,5.39,10.82,17.69,0.0, 0.0,0.0, 0.0, 0.0)
        tableGO1[9] = arrayOf(7.28,8.60,9.22,19.03,3.61,16.55,14.56,11.31,20.62,0.0,0.0, 0.0, 0.0)
        tableGO1[10] = arrayOf(5.0,11.40,3.0,11.40,8.54,13.93,4.47,2.83,14.87,11.66, 0.0, 0.0, 0.0)
        tableGO1[11] = arrayOf(9.22,2.83,13.15,15.23,10.44,10.00,14.21,15.30,15.13,8.60,13.93,0.0, 0.0)
        tableGO1[12] = arrayOf(7.28,8.60,9.22,5.10,12.37,7.07,4.00,10.00,7.81,14.00,7.21,11.40,0.0)




        val tableGO2=Array(13, { Array(13, {0.0}) })
        tableGO2[0] = arrayOf(0.0,3.16,10.44,9.49,10.63,5.83,8.94,12.17,10.05,10.77,10.0,5.83,5.66)
        tableGO2[1] = arrayOf(3.16,0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO2[2] = arrayOf(10.44,11.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO2[3] = arrayOf(9.49,12.65, 13.89, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO2[4] = arrayOf(10.63,9.43, 5.83, 17.46, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)
        tableGO2[5] = arrayOf(5.83,8.25,15.26,7.21,16.40,0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0)
        tableGO2[6] = arrayOf(8.94,11.40,7.28,7.07,12.04,11.05,0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0)
        tableGO2[7] = arrayOf(12.17,13.04,2.24,14.21,7.81,16.55,7.21,0.0, 0.0, 0.0,0.0, 0.0, 0.0)
        tableGO2[8] = arrayOf(10.05,13.0,17.03,4.12,19.70,5.39,10.82,17.69,0.0, 0.0,0.0, 0.0, 0.0)
        tableGO2[9] = arrayOf(10.77,8.60,9.22,19.03,3.61,16.55,14.56,11.31,20.62,0.0,0.0, 0.0, 0.0)
        tableGO2[10] = arrayOf(10.0,11.40,3.0,11.40,8.54,13.93,4.47,2.83,14.87,11.66, 0.0, 0.0, 0.0)
        tableGO2[11] = arrayOf(5.83,2.83,13.15,15.23,10.44,10.00,14.21,15.30,15.13,8.60,13.93,0.0, 0.0)
        tableGO2[12] = arrayOf(5.66,8.60,9.22,5.10,12.37,7.07,4.00,10.00,7.81,14.00,7.21,11.40,0.0)

        val weight = listOf<Double>(450.0,400.0,400.0,200.0,150.0,450.0,250.0,200.0,450.0,300.0,475.0,550.0)


        makeKmWinMatrix(tableGO1)
        makeKmWinMatrix(tableGO2)
        var result1:String=""
        for(i in 0 until makeKmWinMatrix(tableGO1).size){
            for (j in 0 until makeKmWinMatrix(tableGO1).size){
                result1+="${makeKmWinMatrix(tableGO1)[i][j].toString()} "
            }
            result1+="\n"
        }
        var result2:String=""
        for(i in 0 until makeKmWinMatrix(tableGO2).size){
            for (j in 0 until makeKmWinMatrix(tableGO2).size){
                result2+="${makeKmWinMatrix(tableGO2)[i][j].toString()} "
            }
            result2+="\n"
        }

        println("-----")
        println(result1)
        println()
        println(result2)
        println("---")


        val floyds1 = FloydsAlgorithm(result1)
        val floyds2 = FloydsAlgorithm(result2)
        val kmWin1 = KilometerWin(floyds1.returnMasSm())
        val kmWin2 = KilometerWin(floyds2.returnMasSm())

        val clarkRayt1 = ClarkeRightAlgorithm(makeMatrixWithoutGO(kmWin1.returnMatrixKmWin()),weight)

        val clarkRayt2 = ClarkeRightAlgorithm(makeMatrixWithoutGO(kmWin2.returnMatrixKmWin()),weight)


        var resultList = ArrayList<String>()
        var checkDeleteWeight =ArrayList<Int>()

        while (clarkRayt1.listWeight.max()!=0.0 ){
            println("123")
            if(clarkRayt1.returnCheckMaxValues()>clarkRayt2.returnCheckMaxValues()) {
                clarkRayt1.operation()
                resultList.add("ГО1 - ${clarkRayt1.resultListForListRout.last()} - ГО1")

                clarkRayt1.listWeight.forEachIndexed{i,v ->
                    if(v==0.0){
                        checkDeleteWeight.add(i)
                    }
                }

            }else{
                clarkRayt2.operation()
                resultList.add("ГО2 - ${clarkRayt2.resultListForListRout.last()} - ГО2")

                clarkRayt2.listWeight.forEachIndexed{i,v ->
                    if(v==0.0){
                        checkDeleteWeight.add(i)
                    }
                }
            }
            checkDeleteWeight.forEach {
                clarkRayt1.putNull(it)
                clarkRayt2.putNull(it)
            }
            println("<><><><><><><>${clarkRayt1.listWeight}")

        }
        resultList.forEach {
            println(it)
        }
    }




    fun makeKmWinMatrix(matrix:Array<Array<Double>>):Array<Array<Double>>{
        var matrixResult = matrix
        for(i in 0 until matrix.size){
            for (j in 0 until matrix[i].size){
                matrixResult[i][j]=matrix[j][i]
            }
        }
        return matrixResult
    }


}



