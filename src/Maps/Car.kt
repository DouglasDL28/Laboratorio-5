package Maps

class Car (
        private val plate: String,
        private var Xaxis: Int? = null,
        private var Yaxis: Int? = null
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

    override fun toString(): String {
        return "@"
    }
}
