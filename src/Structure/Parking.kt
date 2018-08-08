package Structure

class Parking(
        private var levels: ArrayList<Level> = ArrayList()
) {
    fun findLevel(searchID: Int): Level? {
        val filteredLevels = levels.filter { it.getID() == searchID }
        if (filteredLevels.count() > 0) {
            return filteredLevels[0]
        }
        return null
    }

    fun addLevel(level: Level): Boolean {
        if (findLevel(level.getID())== null) {
            levels.add(level)
            return true
        }
        return false
    }

    fun getLevelsMenu(): String {
        var result = ""
        for (i in levels.indices) {
            result += "${i + 1}. ${levels[i]}"
        }
        return result
    }

    override fun toString(): String {
        return "Parking(levels=$levels)"
    }


}