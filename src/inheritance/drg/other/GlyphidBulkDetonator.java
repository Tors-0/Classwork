package inheritance.drg.other;

public class GlyphidBulkDetonator extends GlyphidExploder {
    public GlyphidBulkDetonator(double h, double t, double mH, double d) {
        super(h, t, mH, d);
        setSize("large");
    }
    @Override
    public void detonate() {
        // still don't know how to represent this
        // triggers a cluster of explosions and an instant-kill radius
    }
}
