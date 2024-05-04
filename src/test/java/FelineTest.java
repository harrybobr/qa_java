import static org.junit.Assert.assertEquals;

import com.example.Feline;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {
  private Feline feline = new Feline();

  @Spy
  private Feline felineSpy = new Feline();

  @Test
  public void testEatMeat() throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    List<String> actualFood = feline.eatMeat();
    Assert.assertEquals(expectedFood, actualFood);
  }

  @Test
  public void testGetFamily() {
    String expectedFamily = "Кошачьи";
    String actualFamily = feline.getFamily();
    Assert.assertEquals(expectedFamily, actualFamily);
  }

  @Test
  public void testGetKittens() {
    int actual = feline.getKittens();
    Assert.assertEquals(1, actual);
  }

  @Test
  public void testKittensCount() {
    int expectedKittensCount = 8;
    int actualKittensCount = feline.getKittens(8);
    Assert.assertEquals(expectedKittensCount, actualKittensCount);
  }

  @Test
  public void getKittensTriggerTimes() {
    felineSpy.getKittens();
    Mockito.verify(felineSpy, Mockito.times(1)).getKittens();
  }

}
