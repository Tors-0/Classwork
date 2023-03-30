package inheritance.drg;

public class GlyphidDreadnought extends Glyphid {

    public GlyphidDreadnought(double h, double t, double mH, double d) {
        super(h, t, mH, d);
        setSize("large");
    }
    public GlyphidDreadnought(double d) {
        super(5000,50,5000,d);
    }
}
