package wmb.checkout;

public class APricer implements Pricer
{
    //3 for 130

    private int count;

    public int price()
    {
        count++;
        if(count % 3 == 0)
        {
            return 30;

        }
        return 50;
    }
}
