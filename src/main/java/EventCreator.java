import pojo.Event;
import org.quartz.CronExpression;
import util.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventCreator {
    private Date dateRefence;

    public EventCreator(Date date) {
        dateRefence = date;
    }

    public EventCreator() {
        dateRefence = new Date();
    }

    public List<Event> getEvents(String cronTab, int duration) throws ParseException {
        ArrayList<Event> events = new ArrayList<Event>();
        CronExpression cronExpression = new CronExpression(cronTab);

        Date nextValidTimeAfter = dateRefence;
        Date dateReferencePlusOne = DateUtils.addDays(dateRefence, 1);
        do {
            nextValidTimeAfter = cronExpression.getNextValidTimeAfter(dateRefence);
            Event event = new Event();
            event.setStart(DateUtils.printDate(nextValidTimeAfter));
            events.add(event);


        } while (nextValidTimeAfter.after(dateReferencePlusOne));


        return events;
    }


}
