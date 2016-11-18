import org.junit.Test;
import pojo.Cron;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CronReaderTest {

    @Test
    public void should_read_cron() throws IOException {
        CronReader cronReader = new CronReader();
        List<Cron> print = cronReader.reader();

        assertEquals(1, print.size());
        assertEquals("0 0 0,5,11,17 * ? *", print.get(0).getCronExpression());

    }

    @Test
    public void should_read_name() throws IOException {
        CronReader cronReader = new CronReader();
        List<Cron> print = cronReader.reader();

        print.stream().forEach(cron -> System.out.println(cron.getName()));

    }
}