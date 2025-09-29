package Library;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static Map<String, Object> getCreatingBooks(String id, String title, String description, String pageCount, String excerpt, String publishDate){
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("id", id);
        payloads.put("title", title);
        payloads.put("description", description);
        payloads.put("pageCount", pageCount);
        payloads.put("excerpt", excerpt);
        payloads.put("publishDate", publishDate);

        return payloads;
    }
}
