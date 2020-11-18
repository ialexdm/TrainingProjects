package Lesson1;

public class Track extends Stage {
    int length;
    static int count;

    public Track(int length){
        super.name = "Track" + ++count;
        this.length = length;

    }
}
