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

    fun deleteLevel (ID: Int):Boolean {
        if (findLevel(ID) != null) {
            levels.remove(findLevel(ID))
        }
        return false
    }

    override fun toString(): String {
        val levelNames = levels.map{it.getName()}.joinToString()
        return """Parking:
            |Levels: $levelNames
        """.trimMargin()
    }


}