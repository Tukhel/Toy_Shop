package ToyShop;

import java.util.PriorityQueue;

class ToyShop extends Toy {
    public ToyShop(int id, String name, int weight) {
        super(id, name, weight);
    }

    public void put(PriorityQueue<Toy> toyQueue, String input) {
        String[] parts = input.split(" ");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int weight = Integer.parseInt(parts[2]);
        Toy newToy = new Toy(id, name, weight);
        toyQueue.add(newToy);
    }

    public Toy get(PriorityQueue<Toy> toyQueue) {
        double rand = Math.random();
        if (rand < 0.2) {
            return searchById(toyQueue, 1);
        } else if (rand < 0.4) {
            return searchById(toyQueue, 2);
        } else {
            return searchById(toyQueue, 3);
        }
    }

    private Toy searchById(PriorityQueue<Toy> toyQueue, int id) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }
}