import com.birdbraintechnologies.*;

import java.util.Scanner;

public class Unit2Project {
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        Finch myFinch = new Finch();
        //System.out.print("What is your name: ");
        //String speech = input.nextLine();
        //String firstName = speech.substring(0,speech.indexOf(" "));
        //String lastName = speech.substring(speech.indexOf(" "));
        // "Hello! I am Finch and I can't speak through the robot, so I use the computer."
        //myFinch.saySomething("Hello there " + firstName + ", " + lastName);
        int time = 7000;
        //myFinch.sleep(time);
        System.out.print("What speed: ");
        //int speed = input.nextInt();
        System.out.print("How long: ");
        //time = input.nextInt();
        time = 850;
        int speed = 75;
        int turnTime = 650;
        myFinch.saySomething("Moving at " + speed + " for " + time);
        myFinch.setWheelVelocities(speed,speed,time);
        myFinch.setWheelVelocities(100,-100,turnTime);
        myFinch.setWheelVelocities(75,75,850);
        myFinch.setWheelVelocities(100,-100,turnTime);
        myFinch.setWheelVelocities(speed,speed,time);
        myFinch.setWheelVelocities(100,-100,turnTime);
        myFinch.setWheelVelocities(75,75,850);
        myFinch.setWheelVelocities(100,-100,turnTime);
        myFinch.quit();
    }
}
