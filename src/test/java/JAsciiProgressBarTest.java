import jasciiprogressbar.JAsciiProgressBar;
import jasciiprogressbar.components.AbsoluteProgress;
import jasciiprogressbar.components.ProgressBar;

import org.junit.Test;

import static org.junit.Assert.*;

public class JAsciiProgressBarTest
{
    @Test
    public void testSimpleBar()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setCurrentProgress(50);
        String result = bar.toString();

        assertTrue(result.contains("50/100"));
        assertTrue(result.contains("50.0%"));
        assertTrue(result.contains("<=====----->"));
    }

    @Test
    public void testChangeProgress()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setCurrentProgress(50);
        assertTrue(bar.toString().contains("50/100"));

        bar.setCurrentProgress(60);
        String result = bar.toString();

        assertTrue(result.contains("60/100"));
        assertTrue(result.contains("60.0%"));
        assertTrue(result.contains("<======---->"));
    }

    @Test
    public void testBarRoundDown()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setCurrentProgress(31);
        assertTrue(bar.toString().contains("<===------->"));
    }

    @Test
    public void testBarRoundUp()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setCurrentProgress(37);
        assertTrue(bar.toString().contains("<====------>"));
    }

    @Test
    public void testBarRoundUpFromHalfway()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setCurrentProgress(65);
        assertTrue(bar.toString().contains("<=======--->"));
    }


    @Test
    public void testDisableShowAbsoluteProgress()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setDrawAbsoluteProgress(false);
        assertFalse(bar.toString().contains("/100"));
    }


    @Test
    public void testDisableShowPercentageProgress()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setDrawPercentageProgress(false);
        assertFalse(bar.toString().contains("%"));
    }


    @Test
    public void testDisableShowProgressBar()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setDrawProgressBar(false);
        assertFalse(bar.toString().contains("<"));
        assertFalse(bar.toString().contains(">"));
    }

    @Test
    public void testPercentageChangeDecimalPlaces()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(10000);
        bar.setPercentageDecimalPlaces(2);
        bar.setCurrentProgress(11);
        assertTrue(bar.toString().contains(" 0.11%"));
        bar.setPercentageDecimalPlaces(1);
        assertTrue(bar.toString().contains(" 0.1%"));
    }

    @Test
    public void testGetAbsoluteProgress()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        AbsoluteProgress ap = bar.getAbsoluteProgress();
        bar.setCurrentProgress(40);
        assertEquals(40, ap.getCurrent());
    }

    @Test
    public void testGetProgressBar()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        ProgressBar pb = bar.getProgressBar();
        bar.setCurrentProgress(40);
        assertEquals("<====------>", pb.toString());
    }

}