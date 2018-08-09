package Maps

import java.util.ArrayList

class Map (
        private val archive: String,
        private val width: Int,
        private val height: Int,
        private var cars: ArrayList<Car> = ArrayList(),
        private var obstacles: ArrayList<Obstacle> = ArrayList(),
        private var lots: ArrayList<Lot> = ArrayList()
)
{
    fun getWidth (): Int {return width}

    fun getHeight (): Int {return height}

    fun findCars (searchCar: String): Car? {
        var filteredCars = cars.filter { it.getPlate() == searchCar }

        if(filteredCars.count() > 0) {
            return filteredCars[0]
        }
        return null
    } //Find a car by plate.

    fun findLot (searchLot: String): Lot? {
        var filteredLots = lots.filter { it.getID() == searchLot }

        if(filteredLots.count() > 0) {
            return filteredLots[0]
        }
        return null
    } //Find a lot by ID.

    fun hasObstacleAt (X: Int, Y: Int): Boolean {
        for (obstacle in obstacles) {
            if ((obstacle.getX() == X) && (obstacle.getY() == Y)) {
                return true
            }
        }
        return false
    } //Check if there is obstacle at XY.

    fun hasCarAt (X: Int, Y: Int): Boolean {
        for (car in cars) {
            if ((car.getX() == X) && (car.getY() == Y)) {
                return true
            }
        }
        return false
    } //Check if there is car at XY.

    fun hasLotAt (X: Int, Y: Int): Boolean {
        for (lot in lots) {
            if ((lot.getX() == X) && (lot.getY() == Y)) {
                return true
            }
        }
        return false
    } //Check if there is lot at XY.

    fun getObstacleAt (X: Int, Y: Int): Obstacle? {
        for (obstacle in obstacles) {
            if (obstacle.getX() == X && obstacle.getY() == Y) {
                return obstacle
            }
        }
        return null
    }

    fun getCarAt (X: Int, Y: Int): Car? {
        for (car in cars) {
            if (car.getX() == X && car.getY() == Y) {
                return car
            }
        }
        return null
    }

    fun getLotAt (X: Int, Y: Int): Lot? {
        for (lot in lots) {
            if (lot.getX() == X && lot.getY() == Y) {
                return lot
            }
        }
        return null
    }

    fun addCar (car: Car): Boolean {
        if (findCars(car.getPlate()) == null) {
            cars.add(car)
            return true
        }
        return false
    } //Add a car in cars list only if there is no other car with same plate.

    fun addObstacle (obstacle: Obstacle) {
        obstacles.add(obstacle)
    } //Add an obstacle to obstacles list. (No condition)

    fun addLot (lot: Lot): Boolean {
        if (findLot(lot.getID()) == null) {
            lots.add(lot)
            return true
        }
        return false
    } //Returns true if there is no other lot in lots list that has the same ID.


    override fun toString(): String {
        var result: String = ""
        for (x in 0..this.height) {
            for (y in 0..this.width) {
                if (hasLotAt(x,y) && hasCarAt(x,y)){
                    val car = getCarAt(x,y)
                    result += car
                }else if (!hasCarAt(x,y) && hasLotAt(x,y)) {
                    val lot = getLotAt(x,y)
                    result += lot
                }else if (hasObstacleAt(x,y)){
                    val obstacle = getObstacleAt(x,y)
                    result += obstacle
                } else {
                    result += " "
                }
            }
            result += "\n"
        }

        return result
    }

}