package Lesson6;

import java.text.MessageFormat;

public class Tree {

    public Tree(){
        System.out.println("Создано дерево");
    }


    private Node root;

    public void insert(Weapon weapon){
        Node node = new Node();
        node.weapon = weapon;
        if (root == null){
            root = node;
        }else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (weapon.id < current.weapon.id){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }
    public Node find(int key){
        Node current = root;
        while (current.weapon.id!= key){
            if (key < current.weapon.id){
                current = current.leftChild;
            }
            else{
                current = current.rightChild;
            }
            if (current == null){
                return  null;
            }
        }
        return current;
    }

    public boolean delete(int id){

        return false;
    }
    public void displayTree(){

    }


    public class Node{
        public Weapon weapon;
        public Node leftChild;
        public Node rightChild;

        public Node(){
            System.out.println("Создан узел");
        }

        public void display(){
            System.out.println(String.format("Name: %s, Damage: %s.", weapon.name, weapon.damage));
        }
    }
}
