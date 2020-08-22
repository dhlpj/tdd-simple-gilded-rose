package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1,8","2,6","3,4","4,2"})
    void should_return_correct_quality_when_pass_several_days_given_gilded_rose_with_expired_general_product(int passedDays, int expectedQuality) {
        List<GeneralProduct> generalProducts = new ArrayList<>();
        GeneralProduct generalProduct = new GeneralProduct(0, 10);
        generalProducts.add(generalProduct);
        GildedRose gildedRose = new GildedRose(generalProducts);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getGeneralProducts().get(0).getQuality());
    }

    @Test
    void should_return_correct_quality_when_product_from_not_expired_to_expired_given_gilded_rose_with_general_product() {
        List<GeneralProduct> generalProducts = new ArrayList<>();
        GeneralProduct generalProduct = new GeneralProduct(5, 10);
        generalProducts.add(generalProduct);
        GildedRose gildedRose = new GildedRose(generalProducts);

        gildedRose.afterDays(7);

        assertEquals(1, gildedRose.getGeneralProducts().get(0).getQuality());
    }

    @Test
    void should_return_0_quality_when_product_pass_12_days_given_gilded_rose_include_general_product_with_10_quality_and_15_sellIn() {
        List<GeneralProduct> generalProducts = new ArrayList<>();
        GeneralProduct generalProduct = new GeneralProduct(15, 10);
        generalProducts.add(generalProduct);
        GildedRose gildedRose = new GildedRose(generalProducts);

        gildedRose.afterDays(12);

        assertEquals(0, gildedRose.getGeneralProducts().get(0).getQuality());
    }

    @Test
    void should_return_0_quality_when_product_pass_6_days_given_gilded_rose_include_expired_general_product_with_10_quality() {
        List<GeneralProduct> generalProducts = new ArrayList<>();
        GeneralProduct generalProduct = new GeneralProduct(0, 10);
        generalProducts.add(generalProduct);
        GildedRose gildedRose = new GildedRose(generalProducts);

        gildedRose.afterDays(6);

        assertEquals(0, gildedRose.getGeneralProducts().get(0).getQuality());
    }
}
