package utilities;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {

	public JsonNode readJSON(String filepath) throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper objmap = new ObjectMapper();
		JsonNode jsonnode = objmap.readTree(new File(filepath));
		return jsonnode;
	}
}
