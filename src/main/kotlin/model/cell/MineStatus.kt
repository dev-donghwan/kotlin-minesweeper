package model.cell

const val MINE_SYMBOL = "*"
const val NOT_MINE_SYMBOL = "C"

enum class MineStatus(private val status: String, private val symbol: String) {
    MINE("MINE", MINE_SYMBOL),
    NOT_MINE("NOT_MINE", NOT_MINE_SYMBOL);

    override fun toString(): String {
        return "$symbol"
    }
}
