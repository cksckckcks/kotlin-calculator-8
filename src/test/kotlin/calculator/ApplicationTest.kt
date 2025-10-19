package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `구분자가 1글자가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//aa\\n1aa2aa3") }
        }
    }

    @Test
    fun `구분자 형식이 잘못된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//aa//1aa2aa3") }
        }
    }

    @Test
    fun `숫자에 음수가 들어온 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//a\\n1a-2a3") }
        }
    }

    @Test
    fun `숫자가 아닌 문자가 있을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1:2:a:3") }
        }
    }

    @Test
    fun `구분자가 연속으로 사용된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1:2::3") }
        }
    }

    @Test
    fun `기본 구분자 2가지 모두 사용한 경우`() {
        assertSimpleTest {
            run("1,1,2:3,3")
            assertThat(output()).contains("결과 : 10")
        }
    }


    override fun runMain() {
        main()
    }
}
