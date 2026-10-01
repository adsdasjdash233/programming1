import org.junit.jupiter.api.*;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        Assertions.assertEquals(sum, a + b); // 값이 같은지 확인

        int result = a + b;
        Assertions.assertEquals(sum, result);
        System.out.println("1 + 2는 3이다");
        Assertions.assertEquals(3, result);
    }

    @DisplayName("1 + 3는 3이다")
    @Test
    public void junitTest2() {
        int a = 1;
        int b = 3;
        int sum = a + b;

        int result = a + b;
        System.out.println("1 + 3는 3이다");
    }

    @BeforeEach
    public void prepare() {
        System.out.println("준비");
    }

    @AfterEach
    public void cleanup() {
        System.out.println("설거지");
    }

    @BeforeEach
    public void before() {
        System.out.println("최초준비");
    }

    @AfterAll
    public static void cleanupClass() {
        System.out.println("최종마무리");
    }
}