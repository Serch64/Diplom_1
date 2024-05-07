package praktikum;

import org.junit.Test;

import static praktikum.IngredientType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTypeTest {
     @Test
     public void ingredientTypeEnumTest() {
          assertThat(IngredientType.values()).containsExactlyInAnyOrder(SAUCE, FILLING);
     }
}
