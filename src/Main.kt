package main

import Maps.Car
import Maps.Lot
import Maps.Map
import Maps.Obstacle
import java.io.File
import java.io.FileNotFoundException
import java.io.StringReader

fun readMap(fileName: String): ArrayList<String> {
    val inputMap = ArrayList<String>()

    try{
        File(fileName).useLines { lines -> inputMap.addAll(lines) }

    } catch (ex: FileNotFoundException) {
        print("Ingrese un archivo válido")
    }
    return inputMap
}

fun createMap(inputMap: ArrayList<String>, fileName: String): Map? {
    val myMap = Map(fileName,inputMap[0].length, inputMap.size)
    for (row in inputMap.indices) {
        for (column in inputMap[0].indices) {
            val toEvaluate: String = inputMap[row].get(column).toString()
            when (toEvaluate){
                "*" -> {
                    val newObstacle = Obstacle(row,column)
                    myMap.addObstacle(newObstacle)
                }

                "0", "1", "2", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Z" -> {
                    val myLot = Lot(row, column, toEvaluate)
                    myMap.addLot(myLot)
                }
            }
        }
    }
    return myMap
}


fun main(args: Array<String>){

    val fileName = "/Users/douglasdeleon/Documents/TestLvl.txt"

    var inputMap = readMap(fileName)

    val lvlMap = createMap(inputMap, fileName)

    print (lvlMap)


}
