package wmb.checkout;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CheckoutTest
{
    public int price(List<String> goods)
    {
        Checkout co = new Checkout(new PricingRules());

        for (String item : goods)
        {
            co.scan(item);
        }
        return co.price;
    }

    @Test
    public void testTotals()
    {
        assertThat(0, equalTo(price(ImmutableList.<String>of())));
        assertThat(50, equalTo(price(ImmutableList.of("A"))));
        assertThat(80, equalTo(price(ImmutableList.of("A", "B"))));
        assertThat(115, equalTo(price(ImmutableList.of("C", "D", "B", "A"))));
        assertThat(100, equalTo(price(ImmutableList.of("A", "A"))));
        assertThat(130, equalTo(price(ImmutableList.of("A", "A", "A"))));
        assertThat(180, equalTo(price(ImmutableList.of("A", "A", "A", "A"))));
        assertThat(390, equalTo(price(ImmutableList.of("A", "A", "A", "A", "A", "A", "A", "A", "A" ))));
        assertThat(230, equalTo(price(ImmutableList.of("A", "A", "A", "A", "A"))));
        assertThat(260, equalTo(price(ImmutableList.of("A", "A", "A", "A", "A", "A"))));
        assertThat(160, equalTo(price(ImmutableList.of("A", "A", "A", "B"))));
        assertThat(175, equalTo(price(ImmutableList.of("A", "A", "A", "B", "B"))));
        assertThat(190, equalTo(price(ImmutableList.of("A", "A", "A", "B", "B", "D"))));
        assertThat(190, equalTo(price(ImmutableList.of("D", "A", "B", "A", "B", "A"))));
    }

    @Test
    public void testIncremental()
    {
        Checkout co = new Checkout(new PricingRules());

        assertThat(0, equalTo(co.price));
        co.scan("A");
        assertThat(50, equalTo(co.price));
        co.scan("B");
        assertThat(80, equalTo(co.price));
        co.scan("A");
        assertThat(130, equalTo(co.price));
        co.scan("A");
        assertThat(160, equalTo(co.price));
        co.scan("B");
        assertThat(175, equalTo(co.price));
    }
}
