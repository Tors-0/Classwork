package inheritance.drg.project;

public class GlyphidGrunt extends Glyphid {
    private boolean isSteeve = false; // glyphid grunts can be tamed to become Steeve, who is friendly

    /**
     * Creates a customizable Grunt
     * @param h spawning health
     * @param t temperature (-30 is freezing, 30 is burning)
     * @param mH max possible health
     * @param d damage dealt per attack
     */
    public GlyphidGrunt(double h, double t, double mH, double d) {
        super(h, t, mH, d);
    }

    /**
     *
     * @param hazardLevel
     * @param playerCount
     */
    public GlyphidGrunt(int hazardLevel, int playerCount) {
        double health = 0;
        switch (hazardLevel) {
            case 1:
                health = 63;
            case 2:
                health = 90;
            case 3:
                health = 99;
            case 4, 5:
                health = 108;
        }
        double damage = 0;
        switch (hazardLevel) {
            case 1:
                damage = 2;
            case 2:
                damage = 2.4 + (0.4 * playerCount);
            case 3:
                damage = 4.4 + (0.4 * playerCount);
            case 4:
                if (playerCount == 4) damage = 10;
                else {
                    damage = 7.4 + (0.6 * playerCount);
                }
            case 5:
                damage = 10.4 + (0.8 * playerCount);
        }
        this(health,0,health,damage);
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
