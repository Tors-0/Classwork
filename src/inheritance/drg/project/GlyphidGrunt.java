package inheritance.drg.project;

public class GlyphidGrunt extends Glyphid {
    private boolean isSteeve = false; // glyphid grunts can be tamed to become Steeve, who is friendly


    /**
     * Creates a glyphid grunt without freeze and burn temp
     * @param h starting health of the grunt
     * @param t starting temperature of the grunt
     * @param mH max health of the grunt
     * @param d damage dealt by grunt
     */
    public GlyphidGrunt(double h, double t, double mH, double d) {
        super(h, t, mH, d, -30, 30, "medium");
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
        if (isSteeve) {
            setHealth(0);
            return 0; // killing a friendly creature returns no vampire points
        }
        else {
            if (getSize().equals("medium") || getSize().equals("large")) {
                setHealth(0);
                return vampLevel + 1;
            } else {
                setHealth(0);
                return 0;
            }
        }
    }

    /**
     * lets you gain health from killing steeve (why would you do this)
     * @param vampLevel level of player's vampire perk
     * @return amount of HP gained from said kill
     */
    public int vampKillIgnoreSteeve(int vampLevel) {
        return super.vampireKill(vampLevel);
    }

    /**
     * Prints out status of current object
     * @return
     */
    public String toString() {
        return super.toString() + ", isSteeve=" + isSteeve;
    }
}
