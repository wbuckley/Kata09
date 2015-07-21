package wmb.checkout;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Receipt
{
    private final PricingRule pricingRule;

    private final Multiset<String> items;

    public Receipt(final PricingRule pricingRule)
    {
        this.pricingRule = pricingRule;
        items = HashMultiset.create();
    }

    public void add(final String item)
    {
        items.add(item);
    }

    public int price()
    {
        return pricingRule.price(items);
    }
}
