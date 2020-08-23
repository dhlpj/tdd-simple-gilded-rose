package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassTest {
    @ParameterizedTest
    @CsvSource({"1,11","2,12","3,13","4,14"})
    void should_add_the_same_as_amount_of_days_to_quality_when_pass_several_days_but_sell_in_greater_than_10_given_gilded_rose_include_backstage_pass_with_10_quality_and_20_sell_in(int passedDays, int expectedQuality) {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(20, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getBackstagePasses().get(0).getQuality());
    }
}
