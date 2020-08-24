package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    @Test
    void should_return_correct_quality_when_pass_several_days_given_gilded_rose_include_backstage_pass_and_general_product() {
        List<Product> products = new ArrayList<>();
        products.add(new BackstagePass(20, 10));
        products.add(new GeneralProduct(20, 10));
        GildedRose gildedRose = new GildedRose(products);

        gildedRose.afterDays(4);

        assertEquals(14, gildedRose.getProducts().get(0).getQuality());
        assertEquals(6, gildedRose.getProducts().get(1).getQuality());
    }
}
