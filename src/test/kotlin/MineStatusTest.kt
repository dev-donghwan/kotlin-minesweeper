import model.cell.MineStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MineStatusTest {
    @Test
    fun `Mine 출력 테스트`() {
        assertThat(MineStatus.MINE.toString()).isEqualTo("*")
    }

    @Test
    fun `NotMine 출력 테스트`() {
        assertThat(MineStatus.MINE.toString()).isEqualTo("*")
    }
}
