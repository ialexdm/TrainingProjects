import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList <T> intoList;
    public Box() {
        intoList = new ArrayList<T>();
    }
    public Box(T ... ts){
        intoList = new ArrayList<T>();
        for (T t : ts) {
            intoList.add(t);;
        }
    }
    public double getWeight(){
        return intoList.size()*intoList.get(0).getWeight();
    }
    public void putInBox(T t){
        intoList.add(t);
    }
    public boolean compare(Box<? extends Fruit> box){
        if (this.getWeight() == box.getWeight() ){
            return true;
        }
        return false;
    }
    public void reFill(Box<T> box){
        for (T t : intoList) {
            box.putInBox(t);
        }
        this.intoList.clear();
    }

}
