package inheritance.drg;

public class Bug {
    private double health;
    private double temperature;
    private boolean isAlive = true;
    private String size;
    private final double maxHealth;
    private boolean isFrozen = false;
    private boolean isBurning = false;
    private double damage;

    public Bug(double h, double t, double mH, double d) {
        health = h;
        isAlive = health >= 0;
        temperature = t;
        maxHealth = mH;
        damage = d;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public double getHealth() {
        return health;
    }
    public double getTemperature() {
        if (temperature < 0) {
            isFrozen = true;
            isBurning = false;
        }
        else if (temperature > 100) {
            isBurning = true;
            isFrozen = false;
        }
        return temperature;
    }
    public String getSize() {
        return size;
    }
    public double getMaxHealth() {
        return maxHealth;
    }

    public boolean checkAlive() {
        if (health < 0) isAlive = false;
        return isAlive;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    /**
     * Changes the bug's health by h
     * @param h accepts negative values
     */
    public void addHealth(double h) {
        this.health += health;
        if (health > maxHealth) health = maxHealth;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void makeHeatCold(double changeTemp) {
        temperature += changeTemp;
        if (temperature < 0) {
            isFrozen = true;
            isBurning = false;
        }
        else if (temperature > 100) {
            isBurning = true;
            isFrozen = false;
        }
    }
}
