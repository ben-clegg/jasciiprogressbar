package jasciiprogressbar.components;

public class AbsoluteProgress
{
    private int current;
    private int end;

    public AbsoluteProgress(int startProgress, int endProgress)
    {
        current = startProgress;
        end = endProgress;
    }

    public void increment()
    {
        current++;
    }

    public void setCurrent(int current)
    {
        this.current = current;
    }

    public int getCurrent()
    {
        return current;
    }

    public int getEnd()
    {
        return end;
    }

    public double getProportionValue()
    {
        return (double) current / (double) end;
    }

    @Override
    public String toString()
    {
        return current + "/" + end;
    }

    public String generatePercentageString(int decimalPlaces)
    {
        return String.format("%." + decimalPlaces + "f", getProportionValue() * 100) + "%";
    }
}
