package ua.ithillel.lesson39_simple_tree;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

}
