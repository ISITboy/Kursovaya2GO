package algorithms

class ClarkeRightAlgorithm(matrix :Array<Array<Double>>, list: List<Double>) {

    var resultListForListRout: MutableList<List<Int>> = mutableListOf()

    var matrixKmWin = matrix
    var listWeight: MutableList<Double> = list.toMutableList()
    var listRout = mutableListOf<Int>()
    var maxValue: Double = 0.0

    val limitWeight =6000.0
    var curWeight = 0.0

    var rowIndexForRout = -1
    var columnIndexForRout = -1

    var checkNext = true


    fun controlCountNullWeight():Int{
        var quantity = 0
        listWeight.forEach {
            if (it == 0.0) {
                quantity++
            }
        }
        return quantity
    }



    fun returnCheckMaxValues():Double{
        var maxValue=0.0
        for (i in 0 until matrixKmWin.size) {
            for (j in 0 until matrixKmWin[i].size) {
                if (matrixKmWin[i][j] >= maxValue) {
                    maxValue = matrixKmWin[i][j]
                }
            }
        }
        return maxValue
    }

    fun operation(){
        findMaxValues()
        while (checkNext) {
            if ((listWeight.size - controlCountNullWeight()) <= 2)
            {
                conditions2()
                checkNext=false
            }else if(maxValue==0.0){
                conditions1()
                checkNext=false
            }
            else findMaxValuesRowAndColumn()
        }
    }

    fun findMaxValues() {
        checkNext = true
        for (i in 0 until matrixKmWin.size) {
            for (j in 0 until matrixKmWin[i].size) {
                if (matrixKmWin[i][j] >= maxValue) {
                    listRout.clear()
                    maxValue = matrixKmWin[i][j]
                    listRout.add(i)
                    listRout.add(j)
                }
            }
        }
        curWeight = listWeight.get(listRout.first()) + listWeight.get(listRout.last())
    }


    fun findMaxValuesRowAndColumn() {
        var maxValueRow = 0.0
        var maxValueColumn = 0.0
        for (i in 0 until matrixKmWin.size) {
            if (matrixKmWin[i][listRout.last()] > maxValueRow && i!=listRout.first()) {
                maxValueRow = matrixKmWin[i][listRout.last()]
                rowIndexForRout = i
            }
        }
        for (i in 0 until matrixKmWin.size) {
            if (matrixKmWin[listRout.first()][i] > maxValueColumn && i !=listRout.last()) {
                maxValueColumn = matrixKmWin[listRout.first()][i]
                columnIndexForRout = i
            }
        }
        addRoutNewPoint(maxValueRow, maxValueColumn)
    }


    fun addRoutNewPoint(valueRow: Double, valueColumn: Double) {
        when (checkLimitWeight(valueRow, valueColumn)) {
            true -> {
                if (valueRow > valueColumn) {
                    putNull(listRout.last())
                    listRout.add(rowIndexForRout)
                    curWeight += listWeight[listRout.last()]
                } else {
                    putNull(listRout.first())
                    listRout.add(0, columnIndexForRout)
                    curWeight += listWeight[listRout.first()]
                }
            }

            false -> {
                checkNext = false
                maxValue = 0.0
                println("curWeight $curWeight")
                curWeight = 0.0
                rowIndexForRout = -1
                columnIndexForRout = -1
                nullMatrix(listRout.first())
                nullMatrix(listRout.last())
                listWeight.set(listRout.first(), 0.0)
                listWeight.set(listRout.last(), 0.0)
                println("rout $listRout")
                println("listWeight $listWeight")
                addRoutInResultListForListRout(listRout)
                listRout.clear()
                readMatrix(matrixKmWin)
            }
        }
    }


    fun checkLimitWeight(valueRow: Double, valueColumn: Double): Boolean {
        var checkCurWeight = curWeight
        checkCurWeight += if (valueRow > valueColumn) {
            listWeight[rowIndexForRout]
        } else {
            listWeight[columnIndexForRout]
        }
        return checkCurWeight <= limitWeight
    }


    fun putNull(index: Int) {
        for (i in 0 until matrixKmWin.size) {
            matrixKmWin[i][index] = 0.0
            matrixKmWin[index][i] = 0.0
        }
        listWeight[index] = 0.0
    }

    fun nullMatrix(ind: Int) {
        for (i in 0 until matrixKmWin.size) {
            matrixKmWin[i][ind] = 0.0
            matrixKmWin[ind][i] = 0.0
        }
    }


    fun addRoutInResultListForListRout(list: MutableList<Int>) {
        val curList = list.toMutableList()
        resultListForListRout.add(curList)
    }


    fun readRout() {
        //println(resultListForListRout.size)
        for (item in resultListForListRout) {
            println(item)
        }
    }


    fun conditions1() {
        var result = mutableListOf<Int>()
        listWeight.forEachIndexed() { index, d ->
            if (d != 0.0) {
                result.add(index)
                listWeight.set(index, 0.0)
            }
        }
        addRoutInResultListForListRout(result)

    }

    fun conditions2() {
        var result = mutableListOf<Int>()
        if (listRout.size==3){
            listRout.reverse()
            addRoutInResultListForListRout(listRout)
            listWeight.forEachIndexed() { i,_->listWeight[i]=0.0 }
        }else{
            listWeight.forEachIndexed() { index, d ->
                if (d != 0.0) {
                    result.add(index)
                    listWeight.set(index, 0.0)
                }
            }
            addRoutInResultListForListRout(result)
        }
    }


    fun readMatrix(matrix: Array<Array<Double>>) {
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                print("${matrix[i][j]} \t")
            }
            println()
        }

    }

}