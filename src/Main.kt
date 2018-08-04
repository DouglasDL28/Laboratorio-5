package main

import Cars.Car
import Lots.Lot
import Maps.Map
import Obstacle.Obstacle
import Structure.Level
import Structure.Parking

fun main(args: Array<String>){

    val newCar = Car("lol")

    println(newCar.plate)

    val newLot = Lot(2,4,"v")

    println(newLot)

}