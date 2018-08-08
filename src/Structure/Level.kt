package Structure

import Maps.Car
import Maps.Map

class Level (
        private val name: String,
        private val ID: Int,
        private val color: String,
        private val map: Map,
        private var cars: ArrayList<Car> = ArrayList()
){
    fun getName (): String {
        return name
    }

    fun getID(): Int {
        return ID
    }

    fun getColor(): String {
        return color
    }

    fun getMap(): String {
        return map.toString()
    }

    fun findCars (searchCar: String): Car? {
        var filteredCars = cars.filter { it.getPlate() == searchCar }

        if(filteredCars.count() > 0) {
            return filteredCars[0]
        }
        return null
    } //Find a car by plate.


    override fun toString(): String {
        return """""Level: '$name'
            | ID: $ID
            | Color: $color
            | $map)""""".trimMargin()
    }
}