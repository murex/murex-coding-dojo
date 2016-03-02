public class BlackProbability {
    public double numerator ;
    public double denominator ;

    public void incrementNumerator()
    {
        numerator++ ;
    }

    public void incrementDenominator()
    {
        denominator++ ;
    }

    public double getRatio()
    {
        if(denominator==0) {
            return -1;
        }
        return numerator / denominator;
    }
    public double getOppositeRatio()
    {
        return 1-getRatio();
    }
}
