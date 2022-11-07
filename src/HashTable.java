public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int size, int step) {
        this.size = size;
        this.step = step;
        slots = new String[size];

        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun(String value) {
        int len = value.getBytes().length;
        return len % size;
    }

    public int seekSlot(String value) {
        int ind = hashFun(value);

        for (int i = 0; i < size; i++, ind += step) {
            if (ind >= size) {
                ind -= size;
            }

            if (slots[ind] == null) {
                return ind;
            }
        }

        return -1;
    }

    public int put(String value) {
        int ind = seekSlot(value);

        if (ind != -1) {
            slots[ind] = value;
            return ind;
        }

        return -1;
    }

    public int find(String key) {
        int ind = hashFun(key);

        for (int i = 0; i < size; i++, ind++) {
            if (ind >= size) {
                ind -= size;
            }

            if (slots[ind] == null) {
                return -1;
            }

            if (slots[ind].equals(key)) {
                return ind;
            }
        }

        return -1;
    }
}
