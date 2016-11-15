import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import pojo.Cron;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CronReader {


    public static final String FILE_NAME = "cron.json";

    public List<Cron> print() throws IOException {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Cron>>(){}.getType();
        return gson.fromJson(getContentString(FILE_NAME), listType);
    }

    public String getContentString(String fileName) throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName);
        return IOUtils.toString(resourceAsStream, "UTF-8");
    }
}
