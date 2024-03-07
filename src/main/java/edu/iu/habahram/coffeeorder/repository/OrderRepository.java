package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(); // For generating unique IDs

    public Receipt add(OrderData order) throws Exception {
        long receiptId = ID_GENERATOR.incrementAndGet();

        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        Receipt receipt = new Receipt( receiptId, beverage.getDescription(), beverage.cost());
        return receipt;
    }

    private void saveOrderToFile(long id, double cost, String description) { // id cost description as specified on canvas
        String line = id + ", " + cost + ", " + description + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("db.txt", true))) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

