import static org.junit.Assert.assertThrows;

import com.example.Feline;
import com.example.Lion;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

@RunWith(Parameterized.class)
public class LionTest {
  private final String sex;
  private final boolean expected;

  public LionTest(String sex, boolean expected) {
    this.sex = sex;
    this.expected = expected;
  }

  @Rule public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

  @Mock Feline mockLion;

  @Parameterized.Parameters
  public static Object[][] testData() {
    return new Object[][] {
      {"Самец", true}, // с гривой
      {"Самка", false}, // без гривы
    };
  }

  @Test
  public void testValidSex() throws Exception {
    Lion leo = new Lion(sex);
    boolean actual = leo.doesHaveMane();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSexException() {
    Exception exception = assertThrows(Exception.class, () -> new Lion("Самолет"));
    String message = exception.getMessage();
    System.out.println(message);
  }

  @Test
  public void testGetKittens() {
    Lion leo = new Lion(sex, mockLion);
    Mockito.when(mockLion.getKittens()).thenReturn(1);
    Assert.assertEquals(1, leo.getKittens());
  }

  @Test
  public void testGetFood() throws Exception {
    Lion leo = new Lion(sex, mockLion);
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Mockito.when(mockLion.getFood("Хищник")).thenReturn(expectedFood);
    Assert.assertEquals(expectedFood, leo.getFood());
  }
}
