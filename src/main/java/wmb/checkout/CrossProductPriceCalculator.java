package wmb.checkout;

import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.List;

public class CrossProductPriceCalculator
{
    private final OverallPercentageDiscount overallPercentageDiscount;

    private final List<String> keys;

    public CrossProductPriceCalculator(final OverallPercentageDiscount overallPercentageDiscount, final String... keys)
    {
        this.overallPercentageDiscount = overallPercentageDiscount;
        this.keys = Arrays.asList(keys);
    }

    public int price(final Multiset<String> items, final int total)
    {
        if(items.containsAll(keys))
        {
            return overallPercentageDiscount.discount(total);
        }
        return total;
    }
}
