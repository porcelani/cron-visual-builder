import pojo.Event;
import org.quartz.CronExpression;
import util.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static util.DateUtils.addMinutes;
import static util.DateUtils.printDate;

public class EventCreator {
    private Date dateRefence;

    public EventCreator(Date date) {
        dateRefence = date;
    }

    public EventCreator() {
        dateRefence = new Date();
    }

    public List<Event> getEvents(String cronTab, int duration, String resourceId) throws ParseException {
        ArrayList<Event> events = new ArrayList<Event>();
        CronExpression cronExpression = new CronExpression(cronTab);

        Date nextValidTimeAfter;
        Date dateReferencePlusOne = DateUtils.addDays(dateRefence, 1);
        do {
            nextValidTimeAfter = cronExpression.getNextValidTimeAfter(dateRefence);
            Event event = new Event();
            event.setStart(printDate(nextValidTimeAfter));
            event.setEnd(printDate(addMinutes(nextValidTimeAfter,duration)));
            event.setResourceId(resourceId);
            events.add(event);

            dateRefence=nextValidTimeAfter;

        } while (nextValidTimeAfter.before(dateReferencePlusOne));


        return events;
    }


}
