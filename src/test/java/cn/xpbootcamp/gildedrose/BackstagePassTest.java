package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassTest {
    @ParameterizedTest
    @CsvSource({"1,11", "2,12", "3,13", "4,14"})
    void should_add_the_same_as_amount_of_days_to_quality_when_pass_several_days_but_sell_in_greater_than_10_given_gilded_rose_include_backstage_pass_with_10_quality_and_20_sell_in(int passedDays, int expectedQuality) {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(20, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @ParameterizedTest
    @CsvSource({"1,12", "2,14", "3,16", "4,18"})
    void should_add_double_amount_of_days_to_quality_when_pass_several_days_but_sell_in_greater_than_10_and_less_equal_than_5_given_gilded_rose_include_backstage_pass_with_10_quality_and_10_sell_in(int passedDays, int expectedQuality) {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(10, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @ParameterizedTest
    @CsvSource({"1,13", "2,16", "3,19", "4,22", "5,25"})
    void should_add_treble_amount_of_days_to_quality_when_pass_several_days_but_sell_in_greater_than_0_and_less_equal_than_5_given_gilded_rose_include_backstage_pass_with_10_quality_and_5_sell_in(int passedDays, int expectedQuality) {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(5, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @ParameterizedTest
    @CsvSource({"1,0", "2,0", "3,0"})
    void should_quality_be_0_when_backstage_pass_through_several_days_given_gilded_rose_include_backstage_pass_with_10_quality_and_0_sell_in(int passedDays, int expectedQuality) {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(0, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(passedDays);

        assertEquals(expectedQuality, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @Test
    void should_quality_equal_to_16_when_its_sell_in_from_greater_than_10_to_lower_than_10_but_greater_than_5_and_pass_4_days_given_gilded_rose_include_backstage_pass_with_10_quality_and_12_sell_in() {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(12, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(4);

        assertEquals(16, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @Test
    void should_quality_equal_to_22_when_its_sell_in_from_greater_than_5_to_lower_than_5_but_greater_than_0_and_pass_5_days_given_gilded_rose_include_backstage_pass_with_10_quality_and_8_sell_in() {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(8, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(5);

        assertEquals(22, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @Test
    void should_quality_equal_to_0_when_its_sell_in_from_greater_than_0_but_lower_than_5_to_lower_than_0_and_pass_5_days_given_gilded_rose_include_backstage_pass_with_10_quality_and_8_sell_in() {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(3, 10));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(5);

        assertEquals(0, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @Test
    void should_max_quality_equal_to_50_when_pass_several_days_given_gilded_rose_include_backstage_pass_with_sell_in_greater_than_10() {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(16, 48));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(4);

        assertEquals(50, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @Test
    void should_max_quality_equal_to_50_when_pass_several_days_given_gilded_rose_include_backstage_pass_with_sell_in_between_5_and_10() {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(10, 45));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(4);

        assertEquals(50, gildedRose.getBackstagePasses().get(0).getQuality());
    }

    @Test
    void should_max_quality_equal_to_50_when_pass_several_days_given_gilded_rose_include_backstage_pass_with_sell_in_between_0_and_5() {
        List<BackstagePass> backstagePasses = new ArrayList<>();
        backstagePasses.add(new BackstagePass(5, 45));
        GildedRose gildedRose = new GildedRose(new ArrayList<>(), backstagePasses);

        gildedRose.afterDays(4);

        assertEquals(50, gildedRose.getBackstagePasses().get(0).getQuality());
    }
}
