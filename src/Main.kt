package main

import Maps.Car
import Maps.Lot

fun main(args: Array<String>){

    val newCar = Car("lol")

    println(newCar.plate)

    val newLot = Lot(2, 4, "v")

    println(newLot)

}