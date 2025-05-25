public class HashFunc1 extends HashTable {
    @Override
    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash ^= (key.charAt(i) * (i + 1));
        }
        return Math.abs(hash) % size;
    }
}
