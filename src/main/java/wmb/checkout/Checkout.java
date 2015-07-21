package wmb.checkout;

public class Checkout
{
    private final Receipt receipt;

    public Checkout(final PricingRule pricingRule)
    {
        receipt = new Receipt(pricingRule);
    }

    public void scan(final String item)
    {
        receipt.add(item);
    }

    public int price()
    {
        return receipt.price();
    }
}
