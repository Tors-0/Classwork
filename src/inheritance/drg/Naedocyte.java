package inheritance.drg;

public class Naedocyte extends Bug {
    /**
     * Creates a Naedocyte object
     * @param h health of the naedocyte
     * @param t starting temperature of the naedocyte
     * @param mH max health of the naedocyte
     * @param d amount of damage the naedocyte deals
     */
    public Naedocyte(double h, double t, double mH, double d) {
        super(h, t, mH, d);
    }
    public Naedocyte() {
        super(20,50,20, 4);
        setSize("small");
    }
}
