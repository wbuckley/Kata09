package wmb.checkout;

import com.google.common.collect.ImmutableMap;

public class PricingRules
{

    private final ImmutableMap<String,Pricer> pricers;

    public PricingRules()
    {
        pricers = ImmutableMap.of("A", new APricer(), "B", new BPricer(), "C", new CPricer(), "D", new DPricer());
    }

    public int append(final String item)
    {
        return pricers.get(item).price();
    }
}
