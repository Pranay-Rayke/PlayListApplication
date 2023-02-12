import java.util.ArrayList;
import java.util.List;

public class Album {

    private String albumName;
    private String artist;
    private List<Song> songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String title) {
        this.albumName = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = song;
    }

    // find song
    boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title))
                return true;
        }
        return false;
    }

    // add Song to album
    String addSongToAlbum(String title, double duration){

        if(findSong(title)==false){
            Song s = new Song(title,duration);
            songs.add(s);
            return "Song added to the album";
        }
        return "Song already exists";
    }

    // concept
    public String addSongToPlaylistfromAlbum(String title, List<Song> playList){
        if(findSong(title)==true){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song not present in album";
    }

    public String addSongToPlaylistfromAlbum(int trackNo, List<Song> playList){

        int index = trackNo-1;
        if(index>=0 && index<this.songs.size()){
            playList.add(this.songs.get(index));
            return "Song has been added to your playList";
        }

        return "Invalid position of song";
    }
}