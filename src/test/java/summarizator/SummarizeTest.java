package summarizator;

import org.junit.Test;
import summarizator.Summarize;

import static org.junit.Assert.assertEquals;


public class SummarizeTest  {
    private Summarize summarize = new Summarize();

    @Test
    public void testSum () throws Exception {
        assertEquals(new Integer(5),summarize.sum(2, 3));

    }
    @Test(expected = IllegalStateException.class)
    public void testSum2()  {
        assertEquals(new Integer(3), summarize.sum(null, 3));
    }
}
