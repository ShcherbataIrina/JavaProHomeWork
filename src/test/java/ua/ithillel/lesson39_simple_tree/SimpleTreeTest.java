package ua.ithillel.lesson39_simple_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTreeTest {
    private SimpleTree tree;

    @BeforeEach
    void setUp() {
        tree = new SimpleTree();
    }

    @Test
    void shouldAddNode() {
        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(7);
        tree.addNode(12);
        tree.addNode(20);
        tree.addNode(13);
        tree.addNode(3);
        tree.addNode(11);

        tree.addNode(3);
        List<Integer> expected = List.of(3, 5, 7, 10, 11, 12, 13, 20);

        assertEquals(expected, tree.printAllElementsInOrder());
        assertEquals(expected.size(), tree.printAllElementsInOrder().size());

    }

}
