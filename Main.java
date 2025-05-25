import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HashTable table1 = new HashFunc1();
        HashTable table2 = new HashFunc2();

        // tabela 1
        long start1 = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("female_names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                table1.insert(line);
            }
        }
        long end1 = System.currentTimeMillis();

        // tabela 2
        long start2 = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("female_names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                table2.insert(line);
            }
        }
        long end2 = System.currentTimeMillis();


        String[] testNames = {"Josue", "Emily", "Charlotte", "Zoe", "Megan"};

        // teste de busca com alto numero de dados

        // String[] testNames = new String[100000];
        // for (int i = 0; i < 100000; i++) {
        //     testNames[i] = "Nome" + i;
        // }

        // search na Tabela 1
        System.out.println("\nResultados da busca na Tabela 1:");
        long searchStart1 = System.currentTimeMillis();
        for (String name : testNames) {
            boolean found = table1.search(name);
            System.out.println("Nome " + name + " encontrado? " + (found ? "Sim" : "Não"));
        }
        long searchEnd1 = System.currentTimeMillis();

        // search na Tabela 2
        System.out.println("\nResultados da busca na Tabela 2:");
        long searchStart2 = System.currentTimeMillis();
        for (String name : testNames) {
            boolean found = table2.search(name);
            System.out.println("Nome " + name + " encontrado? " + (found ? "Sim" : "Não"));
        }
        long searchEnd2 = System.currentTimeMillis();

        System.out.println("\n--- TABELA 1");
        System.out.println("Colisões: " + table1.getCollisions());
        System.out.println("Tempo de inserção: " + (end1 - start1) + "ms");
        System.out.println("Tempo de busca: " + (searchEnd1 - searchStart1) + "ms");
        table1.printDistribution();

        System.out.println("\n--- TABELA 2");
        System.out.println("Colisões: " + table2.getCollisions());
        System.out.println("Tempo de inserção: " + (end2 - start2) + "ms");
        System.out.println("Tempo de busca: " + (searchEnd2 - searchStart2) + "ms");
        table2.printDistribution();
    }
}
