package non_csa.shuffler;

public class Song {
    private final double duration;
    private int playCount;
    private final String name;
    public Song(String name, double duration) {
        playCount = 0;
        this.name = name;
        this.duration = duration;
    }
    public Song(String name, double duration, int plays) {
        playCount = 0;
        this.name = name;
        this.duration = duration;
        playCount = plays;
    }
    public void addPlays() {
        playCount++;
    }
    public int getPlays() {
        return playCount;
    }
    public String getName() {
        return name;
    }
    public double getDuration() {
        return duration;
    }
    public boolean equals(Song other) {
        if (this.name.equals(other.getName())) {
            return this.duration == other.getDuration();
        }
        return false;
    }
    public String toString() {
        return "name=\"" + getName() + "\"&dur=" + getDuration();
    }
}