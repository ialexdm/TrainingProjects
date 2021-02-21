package Lesson3;

public class SinglelinkedList<T> {

    private Link<T> first;

    public SinglelinkedList(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insert(T link){
        Link<T> l = new Link<>(link);
        l.setNext(first);
        this.first = l;
    }
    public Link<T> delete(){
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }
    public void display(){
        Link<T> current = first;
        System.out.print("SinglelinkedList: [ ");
        while(current != null){
            if (!current.equals(first)){
                System.out.print(", ");
            }
            System.out.print(current.getValue());
            current = current.getNext();
        }
        System.out.print(" ]");
        System.out.println();
    }

    public T find(T searchNode){
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current!= null){
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }return null;
    }




    private class Link<T>{
        private T link;
        private Link<T> next;
        public Link(T link){
            this.link = link;
        }
        public Link<T> getNext(){
            return next;
        }
        public void setNext(Link<T> next){
            this.next = next;
        }
        public T getValue(){
            return link;
        }
    }


}
