import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersTest {
    Numbers sut;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("----Start testing----");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("----Tests are finished----");
    }

    @BeforeEach
    public void initEach() {
        sut = new Numbers();
        System.out.println("Начинаем тест модуля");
    }

    @AfterEach
    public void endEach() {
        sut = null;
        System.out.println("Завершили тест модуля");
    }


    @Test
    public void testFindMax() throws Exception {
        //given
        List<Integer> numbers = Arrays.asList(2, 4, 5, 7, 8, 32);
        //when
        sut.findNumber(numbers);
        //then
        Assertions.assertEquals(32, 32);
    }

    @Test
    public void testFindMaxException() {
        //given
        List<Integer> numbers = Arrays.asList();
        //then
        Assertions.assertThrows(NullPointerException.class, () -> sut.findNumber(numbers));


    }

    @Test
    public void testFindMaxTime() {
        //given
        List<Integer> numbers = Stream.iterate(0, n -> n + 1).limit(5000)
                .collect(Collectors.toList());


        //then
        Assertions.assertTimeout(Duration.ofMillis(100), () -> sut.findNumber(numbers));

    }
}
