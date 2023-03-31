package inheritance.drg.other;

public class GlyphidCrassusDetonator extends GlyphidBulkDetonator {
    public GlyphidCrassusDetonator(double h, double t, double mH, double d) {
        super(h, t, mH, d);
        setSize("large");
    }
    @Override
    public void detonate() {
        super.detonate();
        // this one has the same effects as super (BulkDetonator) but it also transforms nearby terrain into gold
    }
}
