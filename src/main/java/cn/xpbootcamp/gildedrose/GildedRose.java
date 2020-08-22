package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    public static final int MIN_PRODUCT_QUALITY = 0;
    public static final int NON_EXPIRED_PRODUCT_QUALITY_REDUCTION = 1;
    public static final int EXPIRED_PRODUCT_QUALITY_REDUCTION = 2;
    private List<GeneralProduct> generalProducts;

    public GildedRose(List<GeneralProduct> generalProducts) {
        this.generalProducts = generalProducts;
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
    }

    private void updateProductQualityAndSellIn(GeneralProduct generalProduct) {
        updateProductQuality(generalProduct);
        updateProductSellIn(generalProduct);
    }

    private void updateProductQuality(GeneralProduct generalProduct) {
        if (generalProduct.getSellIn() <= 0) {
            updateExpiredProductQuality(generalProduct);
        } else {
            generalProduct.setQuality(generalProduct.getQuality() - NON_EXPIRED_PRODUCT_QUALITY_REDUCTION);
        }
    }

    private void updateProductSellIn(GeneralProduct generalProduct) {
        generalProduct.setSellIn(generalProduct.getSellIn() - 1);
    }

    private void updateExpiredProductQuality(GeneralProduct generalProduct) {
        if (generalProduct.getQuality() > EXPIRED_PRODUCT_QUALITY_REDUCTION) {
            generalProduct.setQuality(generalProduct.getQuality() - EXPIRED_PRODUCT_QUALITY_REDUCTION);
        } else {
            generalProduct.setQuality(MIN_PRODUCT_QUALITY);
        }
    }

    public List<GeneralProduct> getGeneralProducts() {
        return generalProducts;
    }
}
