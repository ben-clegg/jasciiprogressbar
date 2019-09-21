package jasciiprogressbar.components;

public class ProgressBar
{
    private int width;

    private AbsoluteProgress progress;

    public ProgressBar(AbsoluteProgress absoluteProgress, int barWidth)
    {
        progress = absoluteProgress;
        setWidth(barWidth);
    }

    public void setWidth(int barWidth)
    {
        width = barWidth;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        sb.append(makeBar());
        sb.append(">");

        return sb.toString();
    }

    private String makeBar()
    {
        int filled = (int) Math.round(progress.getProportionValue() * width);
        if(filled > width)
            filled = width;

        StringBuilder sb = new StringBuilder();
        // Completed
        for (int i = 0; i < filled; i++)
            sb.append("=");
        // Remaining
        for (int i = filled; i < width; i++)
            sb.append("-");

        return sb.toString();
    }
}
