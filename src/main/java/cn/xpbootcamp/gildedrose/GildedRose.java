package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    public static final int MIN_PRODUCT_QUALITY = 0;
    public static final int MAX_PRODUCT_QUALITY = 50;
    private List<GeneralProduct> generalProducts;
    private List<BackstagePass> backstagePasses;

    public GildedRose(List<GeneralProduct> generalProducts, List<BackstagePass> backstagePasses) {
        this.generalProducts = generalProducts;
        this.backstagePasses = backstagePasses;
    }

    public void afterDays(int days) {
        for (GeneralProduct generalProduct : generalProducts) {
            for (; days > 0; days = days - 1) {
                generalProduct.updateProductQualityAndSellIn();
            }
        }
        for (BackstagePass backstagePass : backstagePasses) {
            for (; days > 0; days = days - 1) {
                backstagePass.updateProductQualityAndSellIn();
            }
        }
    }

    public List<GeneralProduct> getGeneralProducts() {
        return generalProducts;
    }

    public List<BackstagePass> getBackstagePasses() {
        return backstagePasses;
    }
}
