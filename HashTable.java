public abstract class HashTable {
    protected int size = 16; // atualizado para 16 posições
    protected Node[] table = new Node[size];
    protected int collisions = 0;
    protected int elements = 0;

    public void insert(String key) {
        int index = hash(key);
        Node current = table[index];

        if (current != null) collisions++;

        Node newNode = new Node(key);
        newNode.next = current;
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

    public boolean remove(String key) {
        int index = hash(key);
        Node current = table[index];
        Node previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                elements--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    public void printDistribution() {
        for (int i = 0; i < size; i++) {
            int count = 0;
            Node current = table[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Índice " + i + ": " + count + " nome(s)");
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public abstract int hash(String key);
}
