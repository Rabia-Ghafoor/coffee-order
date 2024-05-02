package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ReceiptRepository extends CrudRepository<Receipt, String> {

    }




