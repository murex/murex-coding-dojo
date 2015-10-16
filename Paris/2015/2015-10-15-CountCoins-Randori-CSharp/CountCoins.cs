using System.Collections.Generic;
public class CountCoins
{
    private static int quarters = 25;
    private static int dimes = 10;
    private static int nickels = 5;
    private static int pennies = 1;
    
    public static int waysForCents(int value) {
        if(value > 0) {
            var types = new SortedSet<int>() { pennies, nickels, dimes, quarters };
            return waysFor(types, value);
        } else {
            return 0;
        }
    }
    private static int waysFor(SortedSet<int> types, int value) {
        if(types.Count == 1) {
            return 1;
        }
        int max = types.Max;
        var miniTypes = new SortedSet<int>(types);
        miniTypes.Remove(max);
        if(value >= max) {
            return waysFor(types, value-max) + waysFor(miniTypes, value);
        } else {
            return waysFor(miniTypes, value);
        }
    }
}