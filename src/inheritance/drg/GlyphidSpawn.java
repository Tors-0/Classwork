package inheritance.drg;

public class GlyphidSpawn extends Glyphid {
    /**
     *
     * @param t starting temperature of the bug
     * @param d hit damage of the bug (depends on mission hazard level and player count)
     */
    public GlyphidSpawn(double t, double d) {
        super(5, t, 5, d);
    }
}
