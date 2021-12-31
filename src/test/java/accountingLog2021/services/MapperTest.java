package accountingLog2021.services;

import accountingLog2021.domain.Transaction;
import accountingLog2021.models.TransForReport;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    @Test
    void mapTransactionFromSQL() {
        Transaction transaction = new Transaction();
        transaction.setDate(Date.valueOf("2022-01-05"));
        transaction.setTransactionDocNr("Čeks 123");
        transaction.setTransactionPartner("Viada");
        transaction.setTransactionDescription("Degviela");
        transaction.setSum(2.53);
        transaction.setAttitudeForBusiness(50);
        transaction.setRegTime(1640855829650L);
        transaction.setBankCash("BANK");

        Mapper mapper= new Mapper();
        TransForReport transForReport= mapper.mapTransactionFromSQL(transaction);
        System.out.println(transForReport);

    }
}