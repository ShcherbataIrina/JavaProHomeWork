package ua.ithillel.lesson39_simple_tree;

import java.util.ArrayList;
import java.util.List;

class SimpleTree {
    private Node rootNode;

    public void addNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;

            while (true) {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    System.out.println("This item is already in the tree!");
                    return;
                } else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public List<Integer> printAllElementsInOrder() {
       List<Integer> sortedList = new ArrayList<>();
       inOrderTraversal(rootNode, sortedList);
        return sortedList;
    }

    private void inOrderTraversal(Node node, List<Integer> sortedList) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild(), sortedList);
            sortedList.add(node.getValue());
            inOrderTraversal(node.getRightChild(), sortedList);
        }
    }

}
