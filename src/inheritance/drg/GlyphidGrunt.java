package inheritance.drg;

public class GlyphidGrunt extends Glyphid {
    private boolean isSteeve = false;
    public GlyphidGrunt(double h, double t, double mH, double d) {
        super(h, t, mH, d);
    }
    public void becomeSteeve() {
        isSteeve = true;
        setHealth(getMaxHealth());
        setTemperature(50);
    }
}
