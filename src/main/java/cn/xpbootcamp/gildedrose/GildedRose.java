package cn.xpbootcamp.gildedrose;

import java.util.List;

public class GildedRose {
    public static final int MIN_PRODUCT_QUALITY = 0;
    public static final int MAX_PRODUCT_QUALITY = 50;
    private List<? extends Product> products;

    public GildedRose(List<? extends Product> products) {
        this.products = products;
    }

    public void afterDays(int days) {
        for (; days > 0; days = days - 1) {
            for (Product product : products) {
                product.updateProductQualityAndSellIn();
            }
        }
    }

    public List<? extends Product> getProducts() {
        return products;
    }
}
