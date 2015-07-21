package wmb.checkout;

public class OverallPercentageDiscount implements BasketDiscounter
{
    private final int percentage;

    public OverallPercentageDiscount(final int percentage)
    {
        this.percentage = percentage;
    }

    @Override public int discount(final int total)
    {
        double p = 0.01;
        final double v = p * percentage * total;

        return (int) (total - v);
    }
}
