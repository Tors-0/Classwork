//import com.birdbraintechnologies.*;

import java.util.Scanner;

public class Unit2Project {
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        //Finch myFinch = new Finch();
        //exercise 5 vv
        //System.out.print("What is your name: ");
        //String speech = input.nextLine();
        //String firstName = speech.substring(0,speech.indexOf(" "));
        //String lastName = speech.substring(speech.indexOf(" "));
        // "Hello! I am Finch and I can't speak through the robot, so I use the computer."
        //myFinch.saySomething("Hello there " + firstName + ", " + lastName);
        //end exercise 5 ^^
        int time = 2000;
        //myFinch.sleep(time);
        //exercise 18
        //System.out.print("What speed left: ");
        //int speedLeft = input.nextInt();
        //System.out.print("What speed right: ");
        //int speedRight = input.nextInt();
        //System.out.print("How long: ");
        //end exercise 18
        //time = input.nextInt();
        int speed = 75;
        //int turnTime = 650;
        double speakTime = time / 1000.0;
        //exercise 18
        //myFinch.saySomething("Moving at " + speedLeft + " on the left and " + speedRight + "on the right,  for " + speakTime + " seconds.");
        //myFinch.setWheelVelocities(speedLeft,speedRight,time);
        //end exercise 18
        //exercise 16 vv
        //myFinch.setWheelVelocities(100,-100,turnTime);
        //myFinch.setWheelVelocities(75,75,850);
        //myFinch.setWheelVelocities(100,-100,turnTime);
        //myFinch.setWheelVelocities(speed,speed,time);
        //myFinch.setWheelVelocities(100,-100,turnTime);
        //myFinch.setWheelVelocities(75,75,850);
        //myFinch.setWheelVelocities(100,-100,turnTime);
        //end exercise 16 ^^
        //exercise 19
        //myFinch.setLED(255,0,0,2000);
        //end exercise 19
        //exercise 20
        //myFinch.setLED(255,0,255,5000);
        //myFinch.setLED(0,255,255,5000);
        //myFinch.setLED(255,255,0,5000);
        //end exercise 20
        //exercise 21
        //System.out.print("R: ");
        //int R = input.nextInt();
        //System.out.print("G: ");
        //int G = input.nextInt();
        //System.out.print("B: ");
        //int B = input.nextInt();
        //myFinch.setLED(R,G,B,2000);
        //end exercise 21
        //exercise 22: the first one would cause it to set the color to red, then wait 1.5 seconds before moving for another 1.5 seconds
        //the second snippet would change the LED color, then immediately move for 1.5 seconds, then turn off
        //end exercise 22
        //exercise 23
        //myFinch.setLED(0,255,0);
        //myFinch.setWheelVelocities(255,255,2000);
        //myFinch.setLED(255,0,0);
        //myFinch.setWheelVelocities(-255,-255,2000);
        //end exercise 23
        //exercise 24
        //myFinch.setLED(255,0,0);
        int randy = (int)(Math.random()*10) + 10;
        randy *= 1000;
        //myFinch.setWheelVelocities(255,-255,randy);
        //myFinch.setLED(0,255,0,2000);
        //end exercise 24
        //myFinch.quit();
    }
}
