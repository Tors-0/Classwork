import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image {
    public static void main(String args[])throws IOException{
        int width = 963;
        int height = 640;
        BufferedImage image = null;
        File f = null;
        try{
            f = new File("C:\\Users\\Rae\\Downloads\\Input.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(f);
            width = image.getWidth();
            height = image.getHeight();
            System.out.println("Reading complete.");
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
        try{
            f = new File("C:\\Users\\Rae\\Downloads\\Output.jpg");
            ImageIO.write(image,"jpg",f);
            System.out.println("Writing complete.");
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
