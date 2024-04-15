import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testPutAndFind() {
        HashTable table = new HashTable(17, 3);
        table.put("apple");
        table.put("banana");
        table.put("orange");

        assertEquals(3, table.find("apple"));
        assertEquals(14, table.find("banana"));
        assertEquals(7, table.find("orange"));
        assertEquals(-1, table.find("grape"));
    }

    @Test
    public void testHashFun() {
        HashTable table = new HashTable(17, 3);

        assertEquals(3, table.hashFun("apple"));
        assertEquals(14, table.hashFun("banana"));
        assertEquals(7, table.hashFun("orange"));
    }

    @Test
    public void testSeekSlot() {
        HashTable table = new HashTable(17, 3);
        table.put("apple");
        table.put("banana");
        table.put("orange");
        table.put("brol");

        assertEquals(9, table.seekSlot("broz"));
    }

    @Test
    public void testPutWithCollision() {
        HashTable table = new HashTable(17, 3);
        table.put("apple");
        table.put("banana");
        table.put("orange");
        table.put("broz");

        assertEquals(6, table.find("broz"));
    }
}

