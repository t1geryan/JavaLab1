package collection;

import org.example.collection.MyCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyCollectionTest {
    private MyCollection collection;

    @BeforeEach
    void setUp() {
        collection = new MyCollection();
    }

    @Test
    void addAtAddsValueToTheCollectionAtPassedIndex() {
        collection.addAt(0, 10);
        collection.addAt(1, 20);
        collection.addAt(2, 30);

        assertEquals(10, collection.getAt(0));
        assertEquals(20, collection.getAt(1));
        assertEquals(30, collection.getAt(2));
    }

    @Test
    void addAtThrowsIndexOutOfBoundIfPassedIndexLess0MoreSize() {
        collection.addAt(0, 10);

        assertThrows(IndexOutOfBoundsException.class, () -> collection.addAt(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.addAt(2, 50));
    }

    @Test
    void addAtIncreasesSize() {
        collection.addAt(0, 10);
        collection.addAt(0, 20);

        assertEquals(2, collection.size());
    }

    @Test
    void pushAddsValueToTheCollectionEnd() {
        collection.push(10);
        collection.push(20);

        assertEquals(10, collection.getAt(0));
        assertEquals(20, collection.getAt(1));
    }

    @Test
    void pushIncreasesSize() {
        collection.push(10);
        collection.push(20);

        assertEquals(2, collection.size());
    }

    @Test
    void getAtThrowsIndexOutOfBoundIfPassedIndexLess0MoreEqualSize() {
        collection.push(10);
        collection.push(20);

        assertThrows(IndexOutOfBoundsException.class, () -> collection.getAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.getAt(2));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.getAt(3));
    }

    @Test
    void removeRemovesValueFromTheCollectionAtPassedIndex() {
        collection.push(10);
        collection.push(20);
        collection.push(30);

        collection.removeAt(1);

        assertEquals(10, collection.getAt(0));
        assertEquals(30, collection.getAt(1));
    }

    @Test
    void removeDecreasesSize() {
        collection.push(10);
        collection.push(20);

        collection.removeAt(0);

        assertEquals(1, collection.size());
    }

    @Test
    void removeThrowsIndexOutOfBoundIfPassedIndexLess0MoreEqualSize() {
        collection.push(10);
        collection.push(20);

        assertThrows(IndexOutOfBoundsException.class, () -> collection.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.removeAt(2));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.removeAt(3));
    }

    @Test
    void sizeReturnsCountOfItemsInCollection() {
        assertEquals(0, collection.size());

        collection.push(10);
        collection.push(20);
        collection.addAt(0, 50);

        assertEquals(3, collection.size());

        collection.removeAt(1);
        assertEquals(2, collection.size());
    }
}
