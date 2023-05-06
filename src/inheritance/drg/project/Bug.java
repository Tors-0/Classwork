package inheritance.drg.project;

public class Bug {
    private double health;
    // the amount of health the bug currently has
    private double temperature;
    // current temperature of the bug
    private double burnTemp;
    // threshold for the bug to be set on fire
    private double freezeTemp;
    // threshold for the bug to freeze solid
    private boolean isAlive = true;
    // is the bug alive
    private String size;
    // is the bug small, medium, or large
    private final double maxHealth;
    // the maximum health the bug can have
    private boolean isFrozen = false;
    // if the bug reaches frozen temp, then true
    private boolean isBurning = false;
    // if the bug reaches burning temp, then true
    private double damage;
    // how much damage can the bug inflict

    public Bug(double h, double t, double mH, double d) {
        health = h;
        isAlive = health >= 0;
        temperature = t;
        maxHealth = mH;
        damage = d;
    }

    public Bug(double h, double t, double mH, double d, double fT, double bT, String s) {
        health = h;
        isAlive = health >= 0;
        temperature = t;
        maxHealth = mH;
        damage = d;
        freezeTemp = fT;
        burnTemp = bT;
        size = s;
    }

    public Bug() {
        maxHealth = 1;
        health = 1;
        temperature = 0;
        damage = 1;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getHealth() {
        return health;
    }

    /**
     * updates the isFrozen and isBurning booleans
     *
     * @return double temperature of the bug
     */
    public double getTemperature() {
        if (temperature < 0) {
            isFrozen = true;
            isBurning = false;
        } else if (temperature > 100) {
            isBurning = true;
            isFrozen = false;
        }
        return temperature;
    }

    /**
     * gets the size of the bug, small, medium, or large
     *
     * @return String "small" "medium" or "large"
     */
    public String getSize() {
        return size;
    }

    /**
     * get the maximum health of the bug
     *
     * @return double maximum health
     */
    public double getMaxHealth() {
        return maxHealth;
    }

    /**
     * check's if bug is alive, also updates isAlive boolean
     *
     * @return status of isAlive boolean
     */
    public boolean checkAlive() {
        if (health < 0) isAlive = false;
        return isAlive;
    }

    /**
     * sets the bug's health to a certain value
     *
     * @param health the amount of health to set
     */
    public void setHealth(double health) {
        this.health = health;
        checkAlive();
    }

    /**
     * Changes the bug's health by h
     *
     * @param h accepts negative values
     */
    public void addHealth(double h) {
        this.health += health;
        if (health > maxHealth) health = maxHealth;
    }

    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Sets the temperature to a certain value
     *
     * @param temperature the temperature to set to, negative or positive
     */
    public void setTemperature(double temperature) {
        double change = temperature - this.temperature;
        makeHeatCold(change);
    }

    /**
     * change the temperature by an amount, negative or positive
     *
     * @param changeTemp negative or positive double for change in temperature
     */
    public void makeHeatCold(double changeTemp) {
        temperature += changeTemp;
        if (temperature < freezeTemp) {
            isFrozen = true;
            isBurning = false;
        } else if (temperature > burnTemp) {
            isBurning = true;
            isFrozen = false;
        }
    }

    /**
     * Returns int of health gained by killing a creature with the vampire status
     *
     * @param vampLevel level of the vampire perk
     * @return number of HP gained for said kill
     */
    public int vampireKill(int vampLevel) {
        if (getSize().equals("medium") || getSize().equals("large")) {
            setHealth(0);
            return vampLevel + 1;
        } else {
            setHealth(0);
            return 0;
        }
    }

    @Override
    public String toString() {
        String s = "" + getClass();
        return s.substring(s.lastIndexOf(".")+1) + ": health=" + getHealth() + ", temperature=" + getTemperature() + ", maxHealth=" +
                getMaxHealth() + ", damage=" + damage + ", freezeTemp=" + freezeTemp + ", burnTemp=" + burnTemp +
                ", isFrozen=" + isFrozen + ", isBurning=" + isBurning + ", size=" + getSize();
    }
}