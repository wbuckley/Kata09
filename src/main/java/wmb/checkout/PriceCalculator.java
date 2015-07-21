package wmb.checkout;

public class PriceCalculator
{
    private final PriceStrategy pricer;

    private final String key;

    public PriceCalculator(final PriceStrategy pricer, final String key)
    {
        this.pricer = pricer;
        this.key = key;
    }

    public int price(final String item, final int count)
    {
        if(key.equals(item))
        {
        return pricer.price(count);
        }
        return 0;
    }
}
