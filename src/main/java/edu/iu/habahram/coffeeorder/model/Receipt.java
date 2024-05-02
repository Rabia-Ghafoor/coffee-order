package edu.iu.habahram.coffeeorder.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "coffee-orders", name="receipts")
public final class Receipt {

    @Id
    private long receiptId;
    private String description;
    private float cost;

    // constructor
    public Receipt(long receiptId, String description, float cost) {
        this.receiptId = receiptId;
        this.description = description;
        this.cost = cost;
    }

    // default constructor
    public Receipt() {
    }



    // getter method for receiptId
    public long getReceiptId() {
        return receiptId;
    }

    // setter method for receiptId
    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    // getter method for description
    public String getDescription() {
        return description;
    }

    // setter method for description
    public void setDescription(String description) {
        this.description = description;
    }

    // getter method for cost
    public float getCost() {
        return cost;
    }

    // setter method for cost
    public void setCost(float cost) {
        this.cost = cost;
    }


}
