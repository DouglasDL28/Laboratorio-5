package main

import Maps.Car
import Maps.Lot
import Maps.Map
import Maps.Obstacle
import Structure.Level
import Structure.Parking
import java.io.File
import java.io.FileNotFoundException

fun readMap(fileName: String): ArrayList<String> {
    val inputMap = ArrayList<String>()

    try{
        File(fileName).useLines { lines -> inputMap.addAll(lines) }

    } catch (ex: FileNotFoundException) {
        print("Ingrese un archivo válido")
    }
    return inputMap
}

fun createMap(inputMap: ArrayList<String>, fileName: String): Map {
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

fun menu ():String {
    return """Menu:
        |1. Administrador.
        |2. Conductor.
        |3. Salir.
        |
    """.trimMargin()
}

fun adminMenu (): String {
    return """
        1. Crear nivel.
        2. Eliminar nivel
        3. Ver todos los niveles.
        4. Salir a menú principal.

    """.trimIndent()
}

fun driverMenu (): String {
    return """
        1. Agregar un carro a un nivel.
        2. Salir a menú principal.

    """.trimIndent()
}

fun main(args: Array<String>){
    var wantsToContinue = true
    val myParking = Parking()

    do{
        println(menu())
        print("Ingrese una opción: ")
        val option = readLine()!!.toInt()

        when (option){
            1 -> {
                println(adminMenu())
            print("Ingrese una opcion: ")
            val opcionAdmin = readLine()!!.toInt()
            when (opcionAdmin){
                1 -> {
                    print("Ingrese el nombre del nivel que desea agregar: ")
                    val nombre = readLine()!!
                    print("Ingrese el ID del nivel: ")
                    val ID = readLine()!!.toInt()
                    print("Ingrese el color asignado al nivel: ")
                    val color = readLine()!!
                    print ("Ingrese el archivo del mapa del nivel: ")
                    val mapFile = readLine()!!

                    val inputMap = readMap(mapFile)
                    val levelMap = createMap(inputMap, mapFile)
                    val newLevel = Level(nombre,ID,color, levelMap)
                    myParking.addLevel(newLevel)
                } //Crear un nivel.

                2 -> {
                    println("Ingrese el ID del nivel que desea eliminar: ")
                    val levelID = readLine()!!.toInt()
                    myParking.deleteLevel(levelID)
                    println("El nivel se ha eliminado con éxito.")
                } //Eliminar un nivel.

                3 -> { println(myParking.getLevelsMenu()) } //Mostrar niveles.

                4 -> {wantsToContinue = true} //Salir a menú principal
            }
            } //Administrador

            2 -> {
                println(driverMenu())
                print("Ingrese una opción: ")
                val driverOption = readLine()!!.toInt()

                when (driverOption){
                    1 -> {
                        println(myParking.getLevelsMenu())
                        print("Ingrese el ID del nivel al cual desea agregarlo: ")
                        val level = readLine()!!.toInt()

                        print("Ingrese la placa del carro que desea estacionar: ")
                        val plate = readLine()!!

                        print ("Ingrese el estacionamiento en el cual quiere dejar su carro: ")
                        val lotID = readLine()!!

                        if(myParking.findLevel(level)!!.map.findLot(lotID) != null) {
                            val newCar = Car(plate, myParking.findLevel(level)!!.map.findLot(lotID)!!.getX(), myParking.findLevel(level)!!.map.findLot(lotID)!!.getY())

                            myParking.findLevel(level)!!.map.addCar(newCar)
                            myParking.findLevel(level)!!.addCar(newCar)
                        } else{
                            print("El estacionamiento ingresado no es válido")
                        }

                    } //Agregar un carro a un nivel.

                    2 -> {wantsToContinue = true} //Salir a menú principal.
                }
            } //Conductor

            3 -> {wantsToContinue = false} //Salir
            }

    }while(wantsToContinue)

}
