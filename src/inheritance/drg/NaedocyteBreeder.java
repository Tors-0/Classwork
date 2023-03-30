package inheritance.drg;

public class NaedocyteBreeder extends Naedocyte {
    /**
     * Large creature that deals no damage but spawns Naedocytes periodically
     * @param h creature's health
     * @param t creature's starting temperature
     * @param mH creature's max health
     */
    public NaedocyteBreeder(double h, double t, double mH) {
        super(h, t, mH, 0);
        setSize("large");
    }
    public void spawnNaedocytes(String name) {
        // unsure how to represent
        // basically it just creates like 5 Naedocytes with the blank constructor
    }
}
