package jasciiprogressbar;

import jasciiprogressbar.components.AbsoluteProgress;
import jasciiprogressbar.components.ProgressBar;

public class JAsciiProgressBar
{
    private static final int DEFAULT_BAR_WIDTH = 10;

    private AbsoluteProgress progress;
    private ProgressBar bar;

    private boolean drawAbsoluteProgress = true;
    private boolean drawPercentageProgress = true;
    private boolean drawProgressBar = true;

    private int percentageDecimalPlaces = 1;

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
