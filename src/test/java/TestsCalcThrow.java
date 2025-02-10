import calc_oop_test_throw.operations.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Java Advanced Example #7
 *
 * @author Булгаков В.В. 10.02.2025
 * 1. Реализовать покрытие калькулятора unit-тестами
 */

public class TestsCalcThrow {
    //Тест обычного деления
    @Test
    public void testCalcTrowOperationDiv() throws Exception {
        Operation opDiv = new OperationDiv();
        Assert.assertEquals("Тест деления не пройден", -1, opDiv.calculate(-1, 1), 0);
    }

    //Тест Exception при делении
    @Test
    public void testCalcTrowOperationDivZero() throws Exception {
        Operation opDiv = new OperationDiv();
        try {
            Exception exception = Assert.assertThrows(Exception.class, () -> opDiv.calculate(0, 0));

        } catch (Exception e) {
            String expectedMessage = "NAN";
            String actualMessage = e.getMessage();

            Assert.assertTrue(actualMessage.contains(expectedMessage));
            throw new RuntimeException(e);
        }
    }

    //Тест обычного деления по модулю
    @Test
    public void testCalcTrowOperationMod() throws Exception {
        Operation opMod = new OperationMod();
        Assert.assertEquals("Тест деления по модулю не пройден", -1, opMod.calculate(-1, 1), 0);
    }

    //Тест Exception при делении по модулю
    @Test
    public void testCalcTrowOperationModZero() throws Exception {
        Operation opMod = new OperationMod();
        try {
            Exception ee = Assert.assertThrows(Exception.class, () -> opMod.calculate(0, 0));

        } catch (Exception e) {
            String expectedMessage = "NAN";
            String actualMessage = e.getMessage();

            Assert.assertTrue(actualMessage.contains(expectedMessage));
            throw new RuntimeException(e);
        }
    }

    //Тест проверки сложения
    @Test
    public void testCalcTrowOperationSumNotNull() throws Exception {
        Operation opSumNotNull = new OperationSum();
        Assert.assertNotNull(opSumNotNull.calculate(-1, 1));
    }

    //Тест проверки вычитания
    @Test
    public void testCalcTrowOperationMinusNotNull() throws Exception {
        Operation opMinusNotNull = new OperationMinus();
        Assert.assertNotNull(opMinusNotNull.calculate(-1, -1));
    }

    //Тест проверки умножения
    @Test
    public void testCalcTrowOperationMultiNotNull() throws Exception {
        Operation opMultiNotNull = new OperationMulti();
        Assert.assertNotNull(opMultiNotNull.calculate(-1, -1));
    }

}
