package Lesson1;

public class Cat implements Jumpability, Runnability {
    String name;
    int jumpHeight = 10;
    int runDistance = 5;

    public Cat(String name){
        this.name = name;
    }
    public Cat(){
        this.name = "";
    }


    public void jump() {
        System.out.println("Кот " + name + " прыгает");
    }

    public void run() {
        System.out.println("Кот " + name + " бежит");
    }

    public void overcome(Stage stage){
        if(stage instanceof Wall){
            if (((Wall) stage).height <= jumpHeight){
                jump();
                System.out.println("Кот " + this.name + " перепрыгнул стену " +stage.getName());
            }else {
                System.out.println("Кот " + this.name + " не смог перепрыгнуть стену " +stage.getName());
                stage.setWasOvercame(false);
            }
        }else if (stage instanceof Track){
            if (((Track) stage).length <= runDistance){
                run();
                System.out.println("Кот " + this.name + " пробежал дорожку " + stage.getName());
            }else {
                System.out.println("Кот " + this.name + " не смог пробежать дорожку " + stage.getName());
                stage.setWasOvercame(false);
            }
        }

    }
}
