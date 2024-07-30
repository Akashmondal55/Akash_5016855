// RealImage.java
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RealImage implements Image {
    private String filename;
    private String localPath;

    public RealImage(String filename) {
        this.filename = filename;
        this.localPath = "downloads/" + filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image: " + filename + " from server.");
        try {
            URL url = new URL("https://picsum.photos/200/300");
            InputStream in = url.openStream();
            Files.createDirectories(Paths.get("downloads"));
            Files.copy(in, Paths.get(localPath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded and saved as: " + localPath);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
        // In a real application, you would open the image file here
    }
}