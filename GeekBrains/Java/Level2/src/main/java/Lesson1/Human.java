package Lesson1;

public class Human implements Jumpability, Runnability {
    String name;
    int jumpHeight = 5;
    int runDistance = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public Human(String name){
        this.name = name;
    }
    public Human(){
        this.name = "";
    }

    public void jump() {
        System.out.println("Человек " + name + " прыгает");
    }

    public void run() {
        System.out.println("Человек " + name + " бежит");
    }

    public void overcome(Stage stage){
        if(stage instanceof Wall){
            if (((Wall) stage).height <= jumpHeight){
                jump();
                System.out.println("Человек " + this.name + " перепрыгнул стену " +stage.getName());
            }else {
                System.out.println("Человек " + this.name + " не смог перепрыгнуть стену " +stage.getName());
                stage.setWasOvercame(false);
            }
        }else if (stage instanceof Track){
            if (((Track) stage).length <= runDistance){
                run();
                System.out.println("Человек " + this.name + " пробежал дорожку " + stage.getName());
            }else {
                System.out.println("Человек " + this.name + " не смог пробежать дорожку " + stage.getName());
                stage.setWasOvercame(false);

            }
        }

    }
}
