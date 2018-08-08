package Maps

class Car (
        private val plate: String,
        private var Xaxis: Int?,
        private var Yaxis: Int?
)
{
    fun getX (): Int? {
        return Xaxis
    }

    fun getY(): Int? {
        return Yaxis
    }

    fun getPlate(): String {
        return plate
    }

    fun setX(newX: Int?) {
        this.Xaxis = newX
    }

    fun setY(newY: Int?) {
        this.Yaxis = newY
    }

    override fun toString(): String {
        return "@"
    }
}
