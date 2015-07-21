package wmb.checkout;

public class FlatPrice implements PriceStrategy
{
    private final int unitPrice;

    public FlatPrice(final int unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    @Override public int price(final int units)
    {
        final int price = units * unitPrice;
        System.out.println(String.format("%d for %d", units, price));
        return price;
    }
}
