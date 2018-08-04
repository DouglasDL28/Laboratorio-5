package Maps

import Cars.Car
import Lots.Lot
import Obstacle.Obstacle
import java.util.ArrayList

class Map (
        val archive: String,
        val lenght: Int,
        val height: Int,
        private var cars: ArrayList<Car> = ArrayList(),
        private var obstacles: ArrayList<Obstacle> = ArrayList(),
        private var lots: ArrayList<Lot> = ArrayList()
)
{
    fun findCars (searchCar: String): Car? {
        var filteredCars = cars.filter { it.plate == searchCar }

        if(filteredCars.count() > 0) {
            return filteredCars[0]
        }
        return null
    }

    fun findLot (searchLot: String): Lot? {
        var filteredLots = lots.filter { it.ID == searchLot }

        if(filteredLots.count() > 0) {
            return filteredLots[0]
        }
        return null
    }

}