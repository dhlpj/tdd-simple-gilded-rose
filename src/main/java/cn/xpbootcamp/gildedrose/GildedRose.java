package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    private List<GeneralProduct> generalProducts;

    public GildedRose(List<GeneralProduct> generalProducts) {
        this.generalProducts = generalProducts;
    }

    public void afterDays(int days) {
        for (GeneralProduct generalProduct : generalProducts) {
            for (; days > 0; days = days - 1) {
                if (generalProduct.getQuality() == 0) {
                    generalProduct.setSellIn(generalProduct.getSellIn() - 1);
                    continue;
                }
                updateQualityAndSellIn(generalProduct);
            }
        }
    }

    private void updateQualityAndSellIn(GeneralProduct generalProduct) {
        if (generalProduct.getSellIn() <= 0) {
            generalProduct.setQuality(generalProduct.getQuality() - 2);
        } else {
            generalProduct.setQuality(generalProduct.getQuality() - 1);
        }
        generalProduct.setSellIn(generalProduct.getSellIn() - 1);
    }

    public List<GeneralProduct> getGeneralProducts() {
        return generalProducts;
    }
}
