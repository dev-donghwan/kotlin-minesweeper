package model

class Map(val width: Int, val height: Int) {
    val cells: MutableList<Cell> = mutableListOf()
    val mines: List<Cell> = this.cells.filter { it.isMine }

    fun createDefaultMap(width: Int, height: Int) {
        (0 until width).flatMap { x ->
            (0 until height).map { y ->
                this.cells.add(Cell(false, Position(x, y)))
            }
        }
    }

    fun createRandomMines(mineCount: Int) {
        this.cells.shuffled().take(mineCount).forEach {
            notMineToMine(it.position)
        }
    }

    fun calculateMineAroundCount() {
        cells.forEach {
            if (it.isMine) {
                addCount(it.position)
            }
        }
    }

    private fun addCount(position: Position) {
        position.getAroundPositions(width, height).forEach { aroundPosition ->
            cells.find { it.match(aroundPosition) }?.addCount()
        }
    }

    fun clickMap(position: Position) {
        val cell = cells.find { it.match(position) } ?: return
    }

    private fun openCell(position: Position) {
        clickMap(position)
    }

    private fun notMineToMine(position: Position) {
        if (this.cells.removeIf { it.match(position) }) {
            this.cells.add(Cell(true, position))
        }
    }

    override fun toString(): String {
        return this.cells.sortedWith(compareBy({ it.position.x }, { it.position.y })).groupBy { it.position.y }.values.joinToString("\n") { it.joinToString(" ") }
    }
}
