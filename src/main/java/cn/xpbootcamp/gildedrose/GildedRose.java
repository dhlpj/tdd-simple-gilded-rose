package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    public static final int MIN_PRODUCT_QUALITY = 0;
    private List<GeneralProduct> generalProducts;
    private List<BackstagePass> backstagePasses;

    public GildedRose(List<GeneralProduct> generalProducts, List<BackstagePass> backstagePasses) {
        this.generalProducts = generalProducts;
        this.backstagePasses = backstagePasses;
    }

    public void afterDays(int days) {
        for (GeneralProduct generalProduct : generalProducts) {
            for (; days > 0; days = days - 1) {
                if (generalProduct.getQuality() == MIN_PRODUCT_QUALITY) {
                    updateProductSellIn(generalProduct);
                    continue;
                }
                updateProductQualityAndSellIn(generalProduct);
            }
        }
        for (BackstagePass backstagePass : backstagePasses) {
            for (; days > 0; days = days - 1) {
                if (backstagePass.getSellIn() > 10) {
                    backstagePass.setQuality(backstagePass.getQuality() + 1);
                } else if (backstagePass.getSellIn() > 5) {
                    backstagePass.setQuality(backstagePass.getQuality() + 2);
                } else {
                    backstagePass.setQuality(backstagePass.getQuality() + 3);
                }
                backstagePass.setSellIn(backstagePass.getSellIn() - 1);
            }
        }
    }

    private void updateProductQualityAndSellIn(GeneralProduct generalProduct) {
        updateProductQuality(generalProduct);
        updateProductSellIn(generalProduct);
    }

    private void updateProductQuality(GeneralProduct generalProduct) {
        if (generalProduct.getSellIn() <= 0) {
            updateExpiredProductQuality(generalProduct);
        } else {
            generalProduct.setQuality(generalProduct.getQuality() - GeneralProduct.NON_EXPIRED_PRODUCT_QUALITY_REDUCTION);
        }
    }

    private void updateProductSellIn(GeneralProduct generalProduct) {
        generalProduct.setSellIn(generalProduct.getSellIn() - 1);
    }

    private void updateExpiredProductQuality(GeneralProduct generalProduct) {
        if (generalProduct.getQuality() > GeneralProduct.EXPIRED_PRODUCT_QUALITY_REDUCTION) {
            generalProduct.setQuality(generalProduct.getQuality() - GeneralProduct.EXPIRED_PRODUCT_QUALITY_REDUCTION);
        } else {
            generalProduct.setQuality(MIN_PRODUCT_QUALITY);
        }
    }

    public List<GeneralProduct> getGeneralProducts() {
        return generalProducts;
    }

    public List<BackstagePass> getBackstagePasses() {
        return backstagePasses;
    }
}
