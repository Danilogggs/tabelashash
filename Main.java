import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HashTable table1 = new HashFunc1();
        HashTable table2 = new HashFunc2();

        // Tempo inserção tabela 1
        long tempo1S = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("female_names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                table1.insert(line);
            }
        }
        long tempo1F = System.currentTimeMillis();

        // Tempo inserção tabela 2
        long tempo2S = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("female_names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                table2.insert(line);
            }
        }
        long tempo2F = System.currentTimeMillis();

        String[] testNames = {"Josue", "Emily", "Charlotte", "Zoe", "Megan"};

        //  Tempo tabela 1
        System.out.println("\nbusca na Tabela 1:");
        long tempoBusca1S = System.currentTimeMillis();
        for (String name : testNames) {
            boolean found = table1.search(name);
            System.out.println("Nome " + name + " encontrado? " + (found ? "Sim" : "NÃo"));
        }
        long tempoBusca1F = System.currentTimeMillis();

        // Tempo tabela 2
        System.out.println("\nbusca na Tabela 2:");
        long tempoBusca2S = System.currentTimeMillis();
        for (String name : testNames) {
            boolean found = table2.search(name);
            System.out.println("Nome " + name + " encontrado? " + (found ? "Sim" : "NÃo"));
        }
        long tempoBusca2F = System.currentTimeMillis();

        // tabela 1
        System.out.println("\nTABELA 1");
        System.out.println("Colisões: " + table1.getCollisions());
        System.out.println("Tempo de inserção: " + (tempo1F - tempo1S) + " ms");
        System.out.println("Tempo de busca: " + (tempoBusca1F - tempoBusca1S) + " ms");
        table1.printDistribution();

        // tabela 2
        System.out.println("\nTABELA 2");
        System.out.println("Colisões: " + table2.getCollisions());
        System.out.println("Tempo de inserção: " + (tempo2F - tempo2S) + " ms");
        System.out.println("Tempo de busca: " + (tempoBusca2F - tempoBusca2S) + " ms");
        table2.printDistribution();
    }
}
