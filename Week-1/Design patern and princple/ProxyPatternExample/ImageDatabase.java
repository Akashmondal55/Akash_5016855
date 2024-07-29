// ImageDatabase.java
import java.util.HashMap;
import java.util.Map;

public class ImageDatabase {
    private static Map<Integer, String> images = new HashMap<>();

    static {
        for (int i = 1; i <= 100; i++) {
            images.put(i, "image_" + i + ".jpg");
        }
    }

    public static String getImageFilename(int id) {
        return images.get(id);
    }
}