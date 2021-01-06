package programmers;
import java.util.*;

public class 베스트앨범 {
    private class Genre implements Comparable<Genre> {
        public String genre;
        public int plays;
        public List<Song> songs;

        public Genre (String genre, int plays) {
            this.genre = genre;
            this.plays = plays;
            this.songs = new ArrayList<Song>();
        }

        public void sortSongs(){
            Collections.sort(songs);
        }

        public int[] getBests(){
            if(songs.size() >= 2){
                return new int[]{songs.get(0).id, songs.get(1).id};
            }
            else{
                return new int[]{songs.get(0).id};
            }
        }

        @Override
        public int compareTo(Genre genre) {
            if(this.plays > genre.plays)
                return -1;
            else
                return 1;
        }
    }

    private class Song implements Comparable<Song> {
        public int id;
        public int plays;

        public Song (int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song song) {
            if(this.plays == song.plays) {
                if(this.id < song.id)
                    return -1;
                else
                    return 1;
            }
            else if (this.plays > song.plays)
                return -1;
            else
                return 1;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> hm = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(!hm.containsKey(genres[i]))
                hm.put(genres[i], new Genre(genres[i], 0));
            Genre current = hm.get(genres[i]);
            current.plays += plays[i];
            current.songs.add(new Song(i, plays[i]));
        }

        List<Genre> genreList = new ArrayList<Genre>();
        for(Genre genre : hm.values()){
            genreList.add(genre);
            genre.sortSongs();
        }
        Collections.sort(genreList);
        List<Integer> answer = new ArrayList<>();
        for(Genre genre : genreList) {
            int[] bests = genre.getBests();
            for (int id : bests) {
                answer.add(id);
            }
        }

        int[] ret = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            ret[i] = answer.get(i);
        }
        return ret;
    }
}
