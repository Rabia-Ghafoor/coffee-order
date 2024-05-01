package edu.iu.habahram.coffeeorder.repository;

import org.springframework.stereotype.Repository;

public class ReceiptRepository {

    @Repository
    public interface ReceiptRepository extends JpaRepository<Receipt, String> JpaSpecificationExecutor<Receipt> {

    }


}
