public class CodeWriter {
    public static void main(String[] args) {
        int offset = 91;
        String dir = offset / 10 % 2 == 0 ? "left to right" : "right to left";
        System.out.println("// row " + offset + "-" + (offset+9) + ", " + dir);
        for (int i = 0; i < 10; i++) {
            int rtl = (295 - (60*i));
            int ltr = (-245 + (60*i));
            System.out.println("xPos[" + (i+offset) + "] = " + rtl + "; yPos[" + (i+offset) + "] = 240;");
        }
        //
    }
}
