package non_csa.shuffler;

import java.util.ArrayList;

public class Shuffler {
    public static void main(String[] args) {
        ArrayList<Song> playlist0 = new ArrayList<>();
        playlist0.add(new Song("Fathomless Tomb", 544,30));
        playlist0.add(new Song("Dance of the Dreadnaught",132,5));
        playlist0.add(new Song("Let's go deeper",402,9));
        playlist0.add(new Song("A Distant Terror",168,14));
        playlist0.add(new Song("Into The Abyss",384,100));
        playlist0.add(new Song("They're Here",254,8));
        shuffle(playlist0);
        System.out.print(playlist0.toString());
    }
    public static void shuffle(ArrayList<Song> playlist) {
        ArrayList<Song> out = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            Song next = playlist.get(nextSong(playlist));
            next.addPlays();
            out.add(next);
        }
        for (int i = 0; i < out.size(); i++) {
            playlist.set(i,out.get(i));
        }
    }
    public static int nextSong(ArrayList<Song> playlist) {
        int highestPLays = playlist.get(0).getPlays();
        for (Song song : playlist) {
            if (song.getPlays() > highestPLays) {
                highestPLays = song.getPlays();
            }
        }
        // ^ find song with the highest play count //
        ArrayList<Song> lottery = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            for (int j = highestPLays - playlist.get(i).getPlays(); j > 0; j--) {
                lottery.add(playlist.get(i));
            }
        }
        // ^ fill the lottery, 0 entries for song with the highest play count
        return linearSearch(playlist, lottery.get((int) (Math.random() * lottery.size())));
    }
    public static int linearSearch(ArrayList<Song> list, Song target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }
}