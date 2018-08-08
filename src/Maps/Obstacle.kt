package Maps

class Obstacle (
        private val Xaxis: Int,
        private val Yaxis: Int
)
{
    fun getX (): Int {
        return Xaxis
    }

    fun getY (): Int {
        return Yaxis
    }

    override fun toString(): String {
        return "*"
    }
}