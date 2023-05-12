import algorithms.ClarkeRightAlgorithm
import algorithms.FloydsAlgorithm
import algorithms.KilometerWin
import dataGraph.ReadTextFile

fun main(args: Array<String>) {
    val readGraph = ReadTextFile()
    val floyds1 = FloydsAlgorithm(readGraph.textData1)
    val floyds2 = FloydsAlgorithm(readGraph.textData2)
    println("Матрица кратчайших расстояний 1 ГО - СКЛАД Лидская, 15А")
    readMatrix(floyds1.returnMasSm())
    println("Матрица кратчайших расстояний 2 ГО - СКЛАД Победы, 31")
    readMatrix(floyds2.returnMasSm())
    val kmWin1 = KilometerWin(floyds1.returnMasSm())
    val kmWin2 = KilometerWin(floyds2.returnMasSm())
    println("Матрица километровых выйгрышей 1 ГО - СКЛАД Лидская, 15А")
    readMatrix(kmWin1.returnMatrixKmWin())
    println("Матрица километровых выйгрышей 2 ГО - СКЛАД Победы, 31")
    readMatrix(kmWin2.returnMatrixKmWin())

    val weight = listOf<Double>(800.0,800.0,800.0,800.0,800.0,800.0,800.0,800.0,800.0,800.0)

    val clarkRayt1 = ClarkeRightAlgorithm(makeMatrixWithoutGO(kmWin1.returnMatrixKmWin()),weight) //
    val clarkRayt2 = ClarkeRightAlgorithm(makeMatrixWithoutGO(kmWin2.returnMatrixKmWin()),weight)

    clarkRayt1.readRout()
    clarkRayt2.readRout()
    var resultList = ArrayList<String>()
    var checkDeleteWeight =ArrayList<Int>()

    while (clarkRayt1.listWeight.max()!=0.0 ){
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

    }
    resultList.forEach {
        println(it)
    }









}

fun makeKmWinMatrix(matrix:Array<Array<Double>>):Array<Array<Double>>{
    var matrixResult = matrix
    for(i in 0 until matrix.size){
        for (j in 0 until matrix[i].size){
            matrixResult[j][i]=matrix[i][j]
        }
    }
    return matrixResult
}


fun makeMatrixWithoutGO(matrix:Array<Array<Double>>):Array<Array<Double>>{
    val curMatrix : Array<Array<Double>> = Array(matrix.size-1) { Array(matrix.size - 1) { Int.MAX_VALUE.toDouble() } }
    for(i in curMatrix.indices){
        for(j in 0 until curMatrix[i].size){
            curMatrix[i][j]= matrix[i+1][j+1]
        }
    }
    return curMatrix
}


fun readMatrix(matrix:Array<Array<Double>>){
    for (i in 0 until matrix.size) {
        for(j in 0 until  matrix[i].size){
            print("${matrix[i][j]} \t")
        }
        println()
    }
}

