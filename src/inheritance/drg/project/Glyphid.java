package inheritance.drg.project;

public class Glyphid extends Bug {
    public Glyphid(double h, double t, double mH, double d) {
        super(h, t, mH, d);
    }
    public Glyphid(double h, double t, double mH, double d, double fT, double bT, String s) {
        super(h, t, mH, d, fT, bT, s);
    }
}
