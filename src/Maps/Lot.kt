package Maps

class Lot(
        private val Xaxis: Int,
        private val Yaxis: Int,
        private val ID: String
)
{
    fun getX ():Int {
        return Xaxis
    }

    fun getY ():Int {
        return Yaxis
    }

    fun getID (): String {
        return ID
    }

    override fun toString(): String {
        return "$ID"
    }
}