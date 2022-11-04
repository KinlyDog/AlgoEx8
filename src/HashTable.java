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
        int count = 0;

        while (slots[ind] != null && count < size) {
            ind += step;

            if (ind >= size) {
                ind -= size;
            }

            count++;
        }

        if (slots[ind] == null) {
            return ind;
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

    public int find(String value) {
        int ind = hashFun(value);
        int count = 0;

        while (slots[ind] != null && !slots[ind].equals(value) && count < size) {
            ind += step;

            if (ind >= size) {
                ind -= size;
            }

            count++;
        }

        if (slots[ind] != null && slots[ind].equals(value)) {
            return ind;
        }

        return -1;
    }
}
