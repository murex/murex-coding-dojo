using NUnit.Framework;
[TestFixture]
public class CountCoinsTest
{
    [Test]
    public void acceptance_test() {
        int ways = CountCoins.waysForCents(15);
        Assert.AreEqual(6, ways);   
    }
    [Test]
    public void one_way_to_make_0_cents() {
        assertWays(0, 0);
    }
    [Test]
    public void only_one_way_less_than_a_nickel() {
        assertWays(1, 1);
    }
    [Test]
    public void two_ways_for_a_nickel() {
        assertWays(2, 5);
    }
    [Test]
    public void four_ways_for_a_dime() {
        assertWays(4, 10);
    }
    [Test]
    public void _ways_for_a_quarter() {
        assertWays(13, 25);
    }
    [Test]
    public void ways_for_a_100_cents() {
        assertWays(242, 100);
    }
    [Test]
    public void ways_for_negative_money() {
        assertWays(0, -1);
    }
    public static void assertWays(int expected, int cents) {
        Assert.AreEqual(expected, CountCoins.waysForCents(cents));
    }
}