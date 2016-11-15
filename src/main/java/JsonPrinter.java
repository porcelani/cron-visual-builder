import com.google.gson.Gson;
import pojo.Event;

import java.util.ArrayList;

public class JsonPrinter {
    ArrayList<Event> events;

    public JsonPrinter(ArrayList<Event> events) {
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
