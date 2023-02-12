import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Honey 1.0","Yo Yo Honey Singh");
        album1.addSongToAlbum("Brown Rang",5.3);
        album1.addSongToAlbum("Desi Kalakar",4.3);
        album1.addSongToAlbum("Love Dose", 3.4);

        Album album2 = new Album("Badshaha 2.0","Badshaha");
        album2.addSongToAlbum("Genda Phool",5.3);
        album2.addSongToAlbum("Pagal",4.3);
        album2.addSongToAlbum("Mercy", 3.4);

        List<Song> myPlayList = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistfromAlbum("Genda Phool",myPlayList));
        System.out.println(album1.addSongToPlaylistfromAlbum(2,myPlayList));
        System.out.println(album2.addSongToPlaylistfromAlbum("Mercy",myPlayList));
        System.out.println(album1.addSongToPlaylistfromAlbum(3,myPlayList));

        play(myPlayList);
    }

    public static void play(List<Song> playList){

        ListIterator<Song> itr = playList.listIterator();

        if(playList.size()==0){
            System.out.println("Playlist is empty");
            return;
        }

        boolean isNext;
        System.out.println("Currently playing: ");
        System.out.println(itr.next());
        isNext = true;

        Scanner sc = new Scanner(System.in);

        printMenu();
        while(true){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    if(!isNext){
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing");
                        System.out.println(itr.next());
                    }
                    else System.out.println("You have reached the end of list");
                    break;
                case 2:
                    if(isNext){
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing");
                        System.out.println(itr.previous());
                    }
                    else System.out.println("You are on first song already");
                    break;
                case 3:
                    if(isNext==true){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isNext = true;
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    printAllSongs(playList);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:  // exit
                    return;
            }
        }
    }

    static void printAllSongs(List<Song> playList){
        for(Song song: playList)
            System.out.println(song);
        return;
    }

    static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current song");
        System.out.println("5. Show all songs");
        System.out.println("6. Show menu again");
        System.out.println("7. Exit");
    }
}