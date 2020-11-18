package Lesson1;

public class Wall extends Stage {
    static int count =0;
    int height;
    public Wall(int height){
        super.name = "Wall" + ++count;
        this.height = height;
    }
}
