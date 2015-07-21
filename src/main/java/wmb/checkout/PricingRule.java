package wmb.checkout;

import com.google.common.collect.Multiset;

import java.util.List;

public class PricingRule
{
    private final List<PriceCalculator> pricers;

    private final List<CrossProductPriceCalculator> crossProductPriceCalculators;

    public PricingRule(final List<PriceCalculator> p, final List<CrossProductPriceCalculator> q)
    {
        this.pricers = p;
        this.crossProductPriceCalculators = q;
    }

    public int price(final Multiset<String> items)
    {
        return basketPricing(items, itemPricing(items));
    }

    private Integer itemPricing(final Multiset<String> items)
    {
        return items.stream().distinct().sorted().map(s -> pricers.stream().mapToInt(value -> value.price(s, items.count(s))).sum()).reduce(0, (a, b) -> a+b);
    }

    private int basketPricing(final Multiset<String> items, final int total)
    {
        return crossProductPriceCalculators.stream().mapToInt(value -> value.price(items, total)).sum();
    }
}



