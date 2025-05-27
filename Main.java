import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HashTable table1 = new HashFunc1();
        HashTable table2 = new HashFunc2();

        try (BufferedReader reader = new BufferedReader(new FileReader("female_names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                table1.insert(line);
                table2.insert(line);
            }
        }

        String[] testNames = {"Josue", "Emily", "Charlotte", "Zoe", "Megan"};

        System.out.println("\nResultados da busca na Tabela 1:");
        for (String name : testNames) {
            boolean found = table1.search(name);
            System.out.println("Nome " + name + " encontrado? " + (found ? "Sim" : "N\u00e3o"));
        }

        System.out.println("\nResultados da busca na Tabela 2:");
        for (String name : testNames) {
            boolean found = table2.search(name);
            System.out.println("Nome " + name + " encontrado? " + (found ? "Sim" : "N\u00e3o"));
        }

        System.out.println("\n--- TABELA 1");
        System.out.println("Colisões: " + table1.getCollisions());
        table1.printDistribution();

        System.out.println("\n--- TABELA 2");
        System.out.println("Colisões: " + table2.getCollisions());
        table2.printDistribution();
    }
}