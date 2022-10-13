import com.birdbraintechnologies.*;

public class Unit2Project {
    public static void main(final String[] args) {
        Finch myFinch = new Finch();
        myFinch.saySomething("Hello!");
        myFinch.sleep(3000);
        myFinch.quit();
    }
}
