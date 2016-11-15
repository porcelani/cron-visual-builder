import org.junit.Test;
import pojo.Event;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static util.DateUtils.getDate;

public class EventCreatorTest {

    public static final String CRON_TAB = "0 0 12 1/1 * ? *";
    public static final String CRON_TAB2 = "0 0 0,5,11,17 * * ? *";
    public static final String ID = "resourceId";
    public static final int DURATION = 15;

    @Test
    public void should_create_simple_event() throws ParseException {
        Date date = getDate("01/01/2017");
        EventCreator eventCreator = new EventCreator(date);

        List<Event> events = eventCreator.getEvents(CRON_TAB, DURATION, ID);

        assertEquals(1, events.size());
        Event event = events.get(0);
        assertEquals("2017-01-01T12:00:00", event.getStart());
        assertEquals("2017-01-01T12:15:00", event.getEnd());
        assertEquals(ID, event.getResourceId());
    }

    @Test
    public void should_create_event() throws ParseException {
        Date date = getDate("01/01/2017");
        EventCreator eventCreator = new EventCreator(date);

        List<Event> events = eventCreator.getEvents(CRON_TAB2, DURATION, ID);

        assertEquals(4, events.size());
        Event event = events.get(0);
        assertEquals("2017-01-01T05:00:00", event.getStart());
        assertEquals("2017-01-01T05:15:00", event.getEnd());
        assertEquals(ID, event.getResourceId());

        Event event4 = events.get(3);
        assertEquals("2017-01-02T00:00:00", event4.getStart());
        assertEquals("2017-01-02T00:15:00", event4.getEnd());
        assertEquals(ID, event.getResourceId());
    }
}



