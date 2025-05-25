public class HashFunc2 extends HashTable {
    @Override
    public int hash(String key) {
        int p = 31;
        int m = 1_000_000_007;
        long hash = 0;
        long pow = 1;

        for (int i = 0; i < key.length(); i++) {
            hash = (hash + (key.charAt(i) * pow) % m) % m;
            pow = (pow * p) % m;
        }

        return (int)(hash % size);
    }
}
