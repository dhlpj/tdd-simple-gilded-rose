package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    private List<GeneralProduct> generalProducts;

    public GildedRose(List<GeneralProduct> generalProducts) {
        this.generalProducts = generalProducts;
    }

    public void afterDays(int days) {
        for (GeneralProduct generalProduct : generalProducts) {
            generalProduct.setQuality(generalProduct.getQuality() - days);
        }
    }

    public List<GeneralProduct> getGeneralProducts() {
        return generalProducts;
    }
}
