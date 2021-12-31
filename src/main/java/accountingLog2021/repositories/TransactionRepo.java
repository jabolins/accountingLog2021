package accountingLog2021.repositories;

import accountingLog2021.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {

}
