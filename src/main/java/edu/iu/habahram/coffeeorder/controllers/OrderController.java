package edu.iu.habahram.coffeeorder.controllers;

import edu.iu.habahram.coffeeorder.model.*;
import edu.iu.habahram.coffeeorder.repository.ReceiptRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static edu.iu.habahram.coffeeorder.repository.OrderRepository.ID_GENERATOR;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {
  //  private OrderRepository orderRepository;
    private ReceiptRepository receiptRepository;

    public OrderController( ReceiptRepository receiptRepository) {
      //  this.orderRepository = orderRepository;
        this.receiptRepository = receiptRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OrderData order) {
        try {
            Receipt receipt =  coverttoReceipt(order);
            receiptRepository.save(receipt);


            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(receipt);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    private Receipt coverttoReceipt(OrderData order) throws Exception {
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
}
