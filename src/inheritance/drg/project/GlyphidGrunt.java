package inheritance.drg.project;

public class GlyphidGrunt extends Glyphid {
    private boolean isSteeve = false; // glyphid grunts can be tamed to become Steeve, who is friendly
    public GlyphidGrunt(double h, double t, double mH, double d) {
        super(h, t, mH, d);
    }

    /**
     * Attempts to tame Glyphid Grunt to become Steeve
     * @precondition Glyphid grunt must not be tamed already
     */
    public void becomeSteeve() {
        if(!isSteeve) {
            isSteeve = true;
            setHealth(getMaxHealth());
            setTemperature(50);
        }
    }

    /**
     * Returns number of health gained from a vampire kill (melee kill of creature of medium or large size)
     * @param vampLevel level of the player's vampire perk
     * @return number of HP gained
     */
    @Override
    public int vampireKill(int vampLevel) {
        if (isSteeve) return 0; // killing a friendly creature returns no vampire points
        else {
            if (getSize().equals("medium") || getSize().equals("large")) {
                return vampLevel + 1;
            } else {
                return 0;
            }
        }
    }
}
