import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    HashTable ht = new HashTable(17, 3);

    @org.junit.jupiter.api.Test
    void hashFun() {
        // ??
    }

    @org.junit.jupiter.api.Test
    void seekSlot() {
        assertTrue(ht.seekSlot("123") == ht.hashFun("123"));

        for (int i = 0; i < ht.size; i++) {
            ht.put(String.valueOf(i));
        }

        assertTrue(ht.seekSlot("123") == -1);
    }

    @org.junit.jupiter.api.Test
    void put() {
        int tmp = ht.seekSlot("0");

        for (int i = 0; i < ht.size; i++) {
            ht.put(String.valueOf(i));
        }

        assertTrue(ht.find("0") == tmp);
    }

    @org.junit.jupiter.api.Test
    void find() {
        int tmp = ht.seekSlot("123");

        assertTrue(ht.find("123") == -1);
        ht.put("123");

        assertTrue(ht.find("123") == tmp);
    }
}