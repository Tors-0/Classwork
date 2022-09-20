public class Unit1Project {
    public static void main(String[] args) {
        //This is a variable for the first line of the output
        String line1 = genLine1("Rae", "Rae");
        
        //This is a variable for the second line of the output
        String line2 = genLine2("Seattle", "Washington", 2006);
        
        //This is a variable for my current age
        int age = 16;
        //This is a variable for the third line of the output
        String line3 = genLine3(16);
        
        //This is a variable for my age next year
        age += 1; 
        //This is a variable for the fourth line of the output
        String line4 = genLine4(age);
        
        //This is a variable for the fifth line of the output
        String line5 = genLine5("Write code or play games on my PC.");
        
        //This is a variable for the sixth line of the output
        String line6 = genLine6("that I own about 6 computers.");
        
        //This is a variable for the seventh line of the output
        String line7 = genLine7("get a programming job where I can work from home.");
        
        //This is a variable for the eighth line of the output
        String line8 = genLine8("willing to talk to them", false);
        
        //This is a variable for the number of trees in ideal world divided by 1000000 to stay under integer limit
        int treesNum = 4992065;
        //This is a variable for the number of people in the world divided by 1000000 to stay under integer limit
        int numOfHumans = 7800;
        //This is a variable for the ninth line of the output
        String line9 = genLine9(treesNum, numOfHumans, "trees");
        
        //This is a variable for the closing statement of the output, aka lines 10-end
        String line10 = "\n\nSincerely,\nRae";
        
        //This is a variable for the full output of the project
        String output = line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n" + line8 + "\n" + line9 + "\n" + line10;
        
        System.out.print(output);
    }
    public static String genLine1(String name, String nickname) {
        return "Hello, my name is " + name + ", and people call me \"" + nickname + "\".";
    }
    public static String genLine2(String city, String state, int birthYear) {
        return "I was born in " + city + ", " + state + " in " + birthYear;
    }
    public static String genLine3(int age) {
        return "I am currently " + age + " years old.";
    }
    public static String genLine4(int nextAge) {
        return "Next year I will be " + nextAge + " years old.";
    }
    public static String genLine5(String favActivity) {
        return "In my free time I like to " + favActivity;
    }
    public static String genLine6(String unknownFact) {
        return "One thing most people don't know about me is " + unknownFact;
    }
    public static String genLine7(String myHope) {
        return "In the future, I hope to " + myHope;
    }
    public static String genLine8(String fact, boolean correctness) {
        return "People assume that I am " + fact + ", and they are " + correctness;
    }
    public static String genLine9(int trees, int people, String objectName) {
        int perPerson = trees / people;
        double leftOver = (double)trees % people;
        return "In an ideal world, there would be exactly " + perPerson + " " + objectName + " per person, and " + leftOver + " left over.";
    }
}