package inheritance.drg;

public class GlyphidExploder extends Glyphid {
    public GlyphidExploder(double h, double t, double mH, double d) {
        super(h, t, mH, d);
        setSize("medium");
    }
    public void detonate() {
        // again not sure how to implement
        // this is an in game event that triggers terrain destruction and a damage radius
    }
}
