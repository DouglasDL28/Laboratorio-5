package Structure

import Cars.Car
import Maps.Map

class Level (
        val name: String,
        val ID: Int,
        val color: String,
        val map: Map,
        private var cars: ArrayList<Car> = ArrayList()
){

    override fun toString(): String {
        return """""Level: '$name'
            | ID: $ID
            | $map)""""".trimMargin()
    }
}