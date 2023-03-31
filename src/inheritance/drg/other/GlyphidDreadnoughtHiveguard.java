package inheritance.drg.other;

public class GlyphidDreadnoughtHiveguard extends GlyphidDreadnought {
    public GlyphidDreadnoughtHiveguard(double d) {
        super(5000, 50, 5000, d);
    }
    public void summonSentinels() {
        // not sure how to implement, but basically it just creates 3-5 GlyphidSentinel objects
    }
}
