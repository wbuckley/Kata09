package wmb.checkout;

public class BPricer implements Pricer
{
    private int count;

    public int price()
    {
        count++;
        if(count % 2 == 0)
        {
            return 15;
        }
        return 30;
    }
}
