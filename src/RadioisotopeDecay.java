public class RadioisotopeDecay{
    static RadioParticle[] sample = new RadioParticle[100];
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            sample[i] = new RadioParticle();
        }
        while (checkIfAnyAlive()) {
            ageAllUp();
        }
        summary();
    }
    public static void ageAllUp() {
        for (int i = 0; i < 100; i++) {
            sample[i].ageUp();
        }
    }
    public static boolean checkIfAnyAlive() {
        int aliveCount = 0;
        for (int i = 0; i < 100; i++) {
            if (sample[i].isAlive()) {
                aliveCount++;
            }
        }
        System.out.println("Current generation: " + sample[0].age + ",  Number of particles remaining: " + aliveCount);
        if (aliveCount > 0) return true;
        else return false;
    }
    public static void summary() {
        int totalSurvivedCount = 0;
        int maxAge = 0;
        for (int i = 0; i < 100; i++) {
            totalSurvivedCount += sample[i].getSurvivedCount();
            if (sample[i].age >= maxAge) {
                maxAge = sample[i].age;
            }
        }
        double avgSurvived = totalSurvivedCount / 100.0;
        System.out.println("Maximum Age Reached: " + maxAge + "\nAverage Age Reached: " + avgSurvived);
    }
}
class RadioParticle {
    protected int age = 0;
    private boolean alive = true;
    private int survivedCount = 0;
    public RadioParticle() {
        this.age = 0;
        this.alive = true;
        this.survivedCount = 0;
    }
    public void ageUp() {
        this.age += 1;
        if (this.alive) {
            if (Math.random() > 0.55) {
                this.alive = false;
            }
            this.survivedCount++;
        }
    }
    public boolean isAlive() {
        return this.alive;
    }
    public int getSurvivedCount() {
        return this.survivedCount;
    }
}