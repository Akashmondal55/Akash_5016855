// ImageViewerApp.java
import java.util.Scanner;

public class ImageViewerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nImage Viewer Menu:");
            System.out.println("1. View an image");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            if (choice == 2) {
                break;
            } else if (choice == 1) {
                System.out.print("Enter an image ID (1-100): ");
                int imageId = scanner.nextInt();
                
                if (imageId < 1 || imageId > 100) {
                    System.out.println("Invalid image ID. Please enter a number between 1 and 100.");
                    continue;
                }
                
                String filename = ImageDatabase.getImageFilename(imageId);
                Image image = new ProxyImage(filename);
                
                System.out.println("Image " + imageId + " selected.");
                image.display();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
        System.out.println("Thank you for using the Image Viewer App!");
    }
}