package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ReceiptRepository extends JpaRepository<Receipt, String>, JpaSpecificationExecutor<Receipt> {

    }




