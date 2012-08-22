package org.fazio.simsports.core.util;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Michael Fazio
 */
public class JSONLoader {

	public JSONObject loadJSONObjectFromFile(final String filePath) {
		JSONObject jsonObject = new JSONObject();
		try {
			final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filePath);
			if(stream != null) {
				final String jsonString = IOUtils.toString(stream);

				jsonObject = new JSONObject(jsonString);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch(JSONException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
