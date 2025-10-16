package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    @Test
    void 쉼표_구분자_사용_2개_숫자() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 쉼표_구분자_사용_3개_숫자() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_3개의_숫자() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_뒤섞인_기본_구분자() {
        assertSimpleTest(() -> {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                runException("1,2:3");
            });
            assertThat(e.getMessage()).isEqualTo("구분자는 하나만 사용되어야 합니다.");
        });
    }

    @Test
    void 글자_입력() {
        assertSimpleTest(() -> {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                runException("a,2:3");
            });
            assertThat(e.getMessage()).isEqualTo("숫자와 숫자 사이의 구분자로만 작성해야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
