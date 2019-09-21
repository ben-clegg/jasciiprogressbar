package jasciiprogressbar.components;

import jasciiprogressbar.JAsciiProgressBar;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbsoluteProgressTest
{
    @Test
    public void testGetInitialAbsoluteProgress()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        AbsoluteProgress ap = bar.getAbsoluteProgress();
        assertEquals(0, ap.getCurrent());
        assertEquals(100, ap.getEnd());
    }

    @Test
    public void testGetChangedAbsoluteProgress()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        AbsoluteProgress ap = bar.getAbsoluteProgress();
        assertEquals(0, ap.getCurrent());
        assertEquals(100, ap.getEnd());

        bar.incrementProgress();
        assertEquals(1, ap.getCurrent());
        assertEquals(100, ap.getEnd());

        bar.setCurrentProgress(30);
        assertEquals(30, ap.getCurrent());
        assertEquals(100, ap.getEnd());
        assertEquals(ap.getEnd(), 100);
    }
}