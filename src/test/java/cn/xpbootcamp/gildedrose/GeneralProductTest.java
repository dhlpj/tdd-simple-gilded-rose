package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralProductTest {
    @ParameterizedTest
    @CsvSource(value = {"1,9","2,8","3,7","4,6"})
    void should_return_correct_quality_when_pass_several_days_given_gilded_rose_with_general_product_in_sell_in_period(int passedDays, int expectedQuality) {
        List<GeneralProduct> generalProducts = new ArrayList<>();
        GeneralProduct generalProduct = new GeneralProduct(10, 10);
        generalProducts.add(generalProduct);
        GildedRose gildedRose = new GildedRose(generalProducts);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getGeneralProducts().get(0).getQuality());

    }
}
