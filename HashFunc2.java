public class HashFunc2 extends HashTable {
    @Override
    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j <= i; j++) {
                hash += key.charAt(i) * key.charAt(j);
            }
        }
        return Math.abs(hash) % size;
    }
}