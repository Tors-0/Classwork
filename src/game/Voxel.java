package game;

public class Voxel {
    public final int xCord;
    public final int yCord;
    public final int zCord;
    public int hexColor;
    public Voxel(int x, int y, int z, int hex) {
        xCord = x;
        yCord = y;
        zCord = z;
        hexColor = hex;
    }
}
