import jasciiprogressbar.JAsciiProgressBar;
import jasciiprogressbar.components.AbsoluteProgress;
import jasciiprogressbar.components.ProgressBar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class JAsciiProgressBarMainTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setupStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void resetStreams()
    {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testMainAccepted()
    {
        String[] args = {"12", "100"};
        JAsciiProgressBar.main(args);
        assertTrue(outContent.toString().contains("12/100"));
        assertTrue(outContent.toString().contains("12.0%"));
        assertTrue(outContent.toString().contains("<=--------->"));
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testMainNoArgs()
    {
        String[] args = {};
        JAsciiProgressBar.main(args);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testMainOneArg()
    {
        String[] args = {"12"};
        JAsciiProgressBar.main(args);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testMainTooManyArgs()
    {
        String[] args = {"12", "100", "15"};
        JAsciiProgressBar.main(args);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testMainNonIntegerArgs()
    {
        String[] args = {"12.1", "100.0"};
        JAsciiProgressBar.main(args);
    }

}