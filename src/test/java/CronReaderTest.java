import org.junit.Assert;
import org.junit.Test;
import pojo.Cron;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CronReaderTest {

    @Test
    public void shoul_read_crons() throws IOException {
        CronReader cronReader = new CronReader();
        List<Cron> print = cronReader.print();

        assertEquals(1, print.size());
        assertEquals("0 0 0,5,11,17 * ? *", print.get(0).getCron());

    }
}