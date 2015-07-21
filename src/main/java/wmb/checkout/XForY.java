package wmb.checkout;

public class XForY implements PriceStrategy
{
    private final int unitPrice;

    private final int discountPrice;

    private final int unitDiscount;

    public XForY(final int unitDiscount, final int discountPrice, final int unitPrice)
    {
        this.unitDiscount = unitDiscount;
        this.discountPrice = discountPrice;
        this.unitPrice = unitPrice;
    }

    @Override public int price(int units)
    {
        int price = 0;
        for (int i = 0; i < units; )
        {
            price += calc(++i);
        }
        System.out.println(String.format("%d for %d", units, price));
        return price;
    }

    private int calc(final int i)
    {
        if (i % unitDiscount == 0)
        {
            return discountPrice;
        }
        else
        {
            return unitPrice;
        }
    }
}
