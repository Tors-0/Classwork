package inheritance.drg.other;

import inheritance.drg.project.Bug;

public class Mactera extends Bug {
    public Mactera(double h, double t, double mH, double d) {
        super(h, t, mH, d);
        setSize("medium");
    }
}
