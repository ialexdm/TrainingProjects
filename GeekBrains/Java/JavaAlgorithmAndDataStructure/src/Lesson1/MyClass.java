package Lesson1;

public class MyClass {
    public MyClass(){

    }
    public void print(){
        System.out.println(this.toString());
    }
    public boolean equals(MyClass... a){
        long start = System.nanoTime();
        long finish;
        for (int i =0; i< a.length; i++){
            if (a.equals(i)){
                finish = System.nanoTime() - start;
                return true;
            }
        }
        finish = System.nanoTime() - start;
        System.out.println("Algorithm time: " + finish + " nanoseconds.");
        return false;
    }
}
