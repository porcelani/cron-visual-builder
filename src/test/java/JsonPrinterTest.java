import org.junit.Assert;
import org.junit.Test;
import pojo.Event;

import java.text.ParseException;
import java.util.ArrayList;


public class JsonPrinterTest {

    public static final String EXPECTED_JSON =
            "[{\"resourceId\":\"ID\",\"start\":\"2016-09-07T02:00:00\",\"end\":\"2016-09-07T07:00:00\"}]";

    @Test
    public void should_create_simple_event() throws ParseException {

        ArrayList<Event> events = new ArrayList<Event>();
        Event event = new Event();
        event.setStart("2016-09-07T02:00:00");
        event.setEnd("2016-09-07T07:00:00");
        event.setResourceId("ID");
        events.add(event);

        JsonPrinter actual = new JsonPrinter(events);
        Assert.assertEquals(EXPECTED_JSON, actual.print());
    }
}