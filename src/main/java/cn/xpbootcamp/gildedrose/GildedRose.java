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
        for (Product product : products) {
            for (; days > 0; days = days - 1) {
                product.updateProductQualityAndSellIn();
            }
        }
    }

    public List<? extends Product> getProducts() {
        return products;
    }
}
