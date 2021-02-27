package Lesson6;

import java.text.MessageFormat;

public class Tree {

    public Tree() {
        System.out.println("Создано дерево");
    }


    private Node root;

    public void insert(Weapon weapon) {
        Node node = new Node();
        node.weapon = weapon;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (weapon.id < current.weapon.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }

    public Node find(int key) {
        Node current = root;
        while (current.weapon.id != key) {
            if (key < current.weapon.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    private void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            inOrder(rootNode.leftChild);
            inOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            inOrder(rootNode.rightChild);
            rootNode.display();
        }
    }


    public Node min() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (current.weapon.id != id) {
            parent = current;
            if (id < current.weapon.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == null) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current!= null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor!=node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = current.leftChild;
        }
        return successor;
    }



    public void displayTree(){
        Node current = root;
        System.out.println("Симетричный");
        inOrder(root);
        System.out.println("Прямой");
        inOrder(root);
        System.out.println("Обратный");
        inOrder(root);

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
