package jasciiprogressbar.components;

import jasciiprogressbar.JAsciiProgressBar;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgressBarTest
{
    @Test
    public void testChangeWidth()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setBarWidth(10);
        bar.setCurrentProgress(10);

        assertEquals("<=--------->", bar.getProgressBar().toString());

        bar.setBarWidth(20);
        assertEquals("<==------------------>", bar.getProgressBar().toString());

        bar.setBarWidth(30);
        assertEquals("<===--------------------------->", bar.getProgressBar().toString());
    }

    @Test
    public void testExceedingValue()
    {
        JAsciiProgressBar bar = new JAsciiProgressBar(100);
        bar.setBarWidth(10);
        bar.setCurrentProgress(10);
        assertEquals("<=--------->", bar.getProgressBar().toString());

        bar.setCurrentProgress(110);
        assertEquals("<==========>", bar.getProgressBar().toString());
    }
}