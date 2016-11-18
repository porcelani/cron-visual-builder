import pojo.Cron;
import pojo.Event;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] arg) throws IOException {
        CronReader cronReader = new CronReader();
        List<Cron> readers = cronReader.reader();
        List<Event> events= new ArrayList<>();

        readers.stream().forEach(cron-> {
            try {
                EventCreator eventCreator = new EventCreator();
                events.addAll(eventCreator.getEvents(cron.getCronExpression(), cron.getDuration(), cron.getName()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });

        JsonPrinter actual = new JsonPrinter((ArrayList<Event>) events);
        String print = actual.print();
        System.out.print(print);
    }
}
