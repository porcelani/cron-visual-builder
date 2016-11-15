import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pojo.Event;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static util.DateUtils.getDate;

public class EventCreatorTest {

    @Test
    public void should_create_event() throws ParseException {
        Date date = getDate("01/01/2017");
        EventCreator eventCreator = new EventCreator(date);

        List<Event> events = eventCreator.getEvents("0 0 12 1/1 * ? *", 15);

        assertEquals(1, events.size());
        Event event = events.get(0);
        assertEquals("2017-01-01T12:00:00", event.getStart());
    }
}



