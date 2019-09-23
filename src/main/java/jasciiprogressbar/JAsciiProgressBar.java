package jasciiprogressbar;

import jasciiprogressbar.components.AbsoluteProgress;
import jasciiprogressbar.components.ProgressBar;

public class JAsciiProgressBar
{
    private static final int DEFAULT_BAR_WIDTH = 10;

    private final AbsoluteProgress progress;
    private final ProgressBar bar;

    private boolean drawAbsoluteProgress = true;
    private boolean drawPercentageProgress = true;
    private boolean drawProgressBar = true;

    private int percentageDecimalPlaces = 1;

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Example usage: java -jar jasciiprogressbar.jar 12 100");
            throw new IllegalArgumentException("Must include two integer arguments for current progress and final progress.");
        }

        try
        {
            int current = Integer.parseInt(args[0]);
            int end = Integer.parseInt(args[1]);
            JAsciiProgressBar bar = new JAsciiProgressBar(current, end);
            System.out.println(bar);
        }
        catch (NumberFormatException numEx)
        {
            System.out.println("Example usage: java -jar jasciiprogressbar.jar 12 100");
            throw new IllegalArgumentException("Arguments must be integers, of current progress and final progress.");
        }
    }

    public JAsciiProgressBar(int endProgress)
    {
        this(0, endProgress);
    }

    public JAsciiProgressBar(int startProgress, int endProgress)
    {
        progress = new AbsoluteProgress(startProgress, endProgress);
        bar = new ProgressBar(progress, DEFAULT_BAR_WIDTH);
    }

    public void incrementProgress()
    {
        progress.increment();
    }

    public void setCurrentProgress(int currentProgress)
    {
        progress.setCurrent(currentProgress);
    }

    public void setDrawAbsoluteProgress(boolean drawAbsoluteProgress)
    {
        this.drawAbsoluteProgress = drawAbsoluteProgress;
    }

    public void setDrawPercentageProgress(boolean drawPercentageProgress)
    {
        this.drawPercentageProgress = drawPercentageProgress;
    }

    public void setDrawProgressBar(boolean drawProgressBar)
    {
        this.drawProgressBar = drawProgressBar;
    }

    public void setPercentageDecimalPlaces(int percentageDecimalPlaces)
    {
        this.percentageDecimalPlaces = percentageDecimalPlaces;
    }

    public void setBarWidth(int barWidth)
    {
        bar.setWidth(barWidth);
    }

    public AbsoluteProgress getAbsoluteProgress()
    {
        return progress;
    }

    public ProgressBar getProgressBar()
    {
        return bar;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        if (drawAbsoluteProgress)
        {
            sb.append(progress);
            sb.append(" ");
        }

        if(drawProgressBar)
        {
            sb.append(bar);
            sb.append(" ");
        }

        if (drawPercentageProgress)
            sb.append(progress.generatePercentageString(percentageDecimalPlaces));

        return sb.toString().trim();
    }
}
