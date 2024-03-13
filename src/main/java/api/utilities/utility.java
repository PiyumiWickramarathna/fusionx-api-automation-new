package api.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class utility {
    public static JSONObject jsonReader(String path) throws IOException, ParseException{
        String jsonBody = new String(Files.readAllBytes(Paths.get(path)));
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonBody);
    }
}
