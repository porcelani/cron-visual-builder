import com.google.gson.Gson;
import pojo.Event;

import java.util.ArrayList;
import java.util.List;

public class JsonPrinter {
    List<Event> events;

    public JsonPrinter(List<Event> events) {
        this.events = events;
    }

    public String print() {
        Gson gson = new Gson();
        return gson.toJson(events);
    }

    public void printInFile() {
        print();
    }
}
