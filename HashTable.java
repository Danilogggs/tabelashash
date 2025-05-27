public abstract class HashTable {
    protected int size = 16;
    protected Node[] table = new Node[size];
    protected int collisions = 0;
    protected int elements = 0;
    protected final double loadFactorThreshold = 0.75;

    public void insert(String key) {
        if ((double) elements / size > loadFactorThreshold) {
            resize();
        }

        int index = hash(key);

        Node newNode = new Node(key);
        newNode.next = table[index];

        if (table[index] != null) collisions++;

        table[index] = newNode;
        elements++;
    }

    public boolean search(String key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) return true;
            current = current.next;
        }
        return false;
    }

//    public boolean delete(String key) {
//        int index = hash(key);
//        Node current = table[index];
//        Node previous = null;
//
//        while (current != null) {
//            if (current.key.equals(key)) {
//                if (previous == null) {
//                    table[index] = current.next;
//                } else {
//                    previous.next = current.next;
//                }
//                elements--;
//                return true;
//            }
//            previous = current;
//            current = current.next;
//        }
//        return false;
//    }

    private void resize() {
        int oldSize = size;
        size *= 2;
        Node[] oldTable = table;
        table = new Node[size];
        elements = 0;
        collisions = 0;

        for (int i = 0; i < oldSize; i++) {
            Node current = oldTable[i];
            while (current != null) {
                insert(current.key);
                current = current.next;
            }
        }
    }

    public void printDistribution() {
        for (int i = 0; i < size; i++) {
            int count = 0;
            Node current = table[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("\u00cdndice " + i + ": " + count + " nome(s)");
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public abstract int hash(String key);
}