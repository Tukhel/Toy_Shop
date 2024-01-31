package ToyShop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());
        
        ToyShop toyShop = new ToyShop(0, "", 0); // создаем экземпляр ToyShop
        
        // Добавление новых игрушек
        toyShop.put(toyQueue, "1 Конструктор 2");
        toyShop.put(toyQueue, "2 Робот 2");
        toyShop.put(toyQueue, "3 Кукла 6");
        
        // Общая очередь
        for (int i = 0; i < 10; i++) {
            Toy randomToy = toyShop.get(toyQueue);
            System.out.println(randomToy.getId());
            writeToFile("raffle.txt", String.valueOf(randomToy.getId()));
        }
    }

    private static void writeToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(content + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
