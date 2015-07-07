package wmb.checkout;

public class Checkout
{
    private PricingRules pricingRules;

    public int price;

    public Checkout(final PricingRules pricingRules)
    {
        this.pricingRules = pricingRules;
    }

    public void scan(final String item)
    {
        price += pricingRules.append(item);
    }

    public int price()
    {
        return price;
    }
}
