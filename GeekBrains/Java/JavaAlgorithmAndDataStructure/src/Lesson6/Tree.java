package Lesson6;

import java.text.MessageFormat;

public class Tree {


    private class Node{
        public Weapon weapon;
        public Node leftChild;
        public Node rightChild;

        public void display(){
            System.out.println(MessageFormat.format("Name: %s, Damage: %s.", weapon.name, weapon.damage));
        }
    }
}
