public class HashFunc2 extends HashTable {
    @Override
    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash^4 * key.charAt(i) * (i + 1);
        }
        return hash % size;
    }
}