import com.example.Cat;
import com.example.Feline;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
  @Mock Feline mockFeline;

  @Test
  public void testGetSound() {
    Cat kitty = new Cat(mockFeline);
    String actualSound = kitty.getSound();
    String expectedSound = "Мяу";
    Assert.assertEquals(expectedSound, actualSound);
  }

  @Test
  public void testGetFood() throws Exception {
    Cat kitty = new Cat(mockFeline);
    List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
    Mockito.when(mockFeline.eatMeat()).thenReturn(expectedList);
    Assert.assertEquals(expectedList, kitty.getFood());
  }
}
