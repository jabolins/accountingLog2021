package accountingLog2021.services;

import accountingLog2021.domain.Transaction;
import accountingLog2021.models.TransForReport;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    @Test
    void mapTransactionFromSQLBankIssued() {
        Transaction transaction = new Transaction();
        transaction.setDate(Date.valueOf("2022-01-05"));
        transaction.setTransactionDocNr("Čeks 123");
        transaction.setTransactionPartner("Viada");
        transaction.setTransactionDescription("Degviela");
        transaction.setSum(-2.53);
        transaction.setAttitudeForBusiness(50);
        transaction.setRegTime(1640855829650L);
        transaction.setBankCash("BANK");

        Mapper mapper= new Mapper();
        TransForReport transForReport= mapper.mapTransactionFromSQL(transaction);
        //System.out.println(transForReport);
 String expectedValue= "TransForReport{id=null" +
         ", date='2022-01-05'" +
         ", docNr='Čeks 123'" +
         ", partner='Viada'" +
         ", transDescription='Degviela'" +
         ", cashReceived=null" +
         ", cashIssued=null" +
         ", bankReceived=null" +
         ", bankIssued=2.53" +
         ", businessReceived=null" +
         ", notBusinessReceived=null" +
         ", totalReceived=null" +
         ", businessIssued=1.27" +
         ", notBusinessIssued=1.26" +
         ", totalIssued=2.53" +
         ", attitudeForBusiness=50" +
         ", registrationTime=2021-12-30}";
 assertEquals(expectedValue,transForReport.toString());
    }

    @Test
    void mapTransactionFromSQLCashIssued() {
        Transaction transaction = new Transaction();
        transaction.setDate(Date.valueOf("2022-01-05"));
        transaction.setTransactionDocNr("Čeks 123");
        transaction.setTransactionPartner("Viada");
        transaction.setTransactionDescription("Degviela");
        transaction.setSum(-2.53);
        transaction.setAttitudeForBusiness(50);
        transaction.setRegTime(1640855829650L);
        transaction.setBankCash("CASH");

        Mapper mapper= new Mapper();
        TransForReport transForReport= mapper.mapTransactionFromSQL(transaction);
        //System.out.println(transForReport);
        String expectedValue= "TransForReport{id=null" +
                ", date='2022-01-05'" +
                ", docNr='Čeks 123'" +
                ", partner='Viada'" +
                ", transDescription='Degviela'" +
                ", cashReceived=null" +
                ", cashIssued=2.53" +
                ", bankReceived=null" +
                ", bankIssued=null" +
                ", businessReceived=null" +
                ", notBusinessReceived=null" +
                ", totalReceived=null" +
                ", businessIssued=1.27" +
                ", notBusinessIssued=1.26" +
                ", totalIssued=2.53" +
                ", attitudeForBusiness=50" +
                ", registrationTime=2021-12-30}";
        assertEquals(expectedValue,transForReport.toString());
    }

    @Test
    void mapTransactionFromSQLBankReceived() {
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
        //System.out.println(transForReport);
        String expectedValue= "TransForReport{id=null" +
                ", date='2022-01-05'" +
                ", docNr='Čeks 123'" +
                ", partner='Viada'" +
                ", transDescription='Degviela'" +
                ", cashReceived=null" +
                ", cashIssued=null" +
                ", bankReceived=2.53" +
                ", bankIssued=null" +
                ", businessReceived=1.27" +
                ", notBusinessReceived=1.26" +
                ", totalReceived=2.53" +
                ", businessIssued=null" +
                ", notBusinessIssued=null" +
                ", totalIssued=null" +
                ", attitudeForBusiness=50" +
                ", registrationTime=2021-12-30}";
        assertEquals(expectedValue,transForReport.toString());
    }
    @Test
    void mapTransactionFromSQLCashReceived() {
        Transaction transaction = new Transaction();
        transaction.setDate(Date.valueOf("2022-01-05"));
        transaction.setTransactionDocNr("Čeks 123");
        transaction.setTransactionPartner("Viada");
        transaction.setTransactionDescription("Degviela");
        transaction.setSum(2.53);
        transaction.setAttitudeForBusiness(50);
        transaction.setRegTime(1640855829650L);
        transaction.setBankCash("CASH");

        Mapper mapper= new Mapper();
        TransForReport transForReport= mapper.mapTransactionFromSQL(transaction);
        //System.out.println(transForReport);
        String expectedValue= "TransForReport{id=null" +
                ", date='2022-01-05'" +
                ", docNr='Čeks 123'" +
                ", partner='Viada'" +
                ", transDescription='Degviela'" +
                ", cashReceived=2.53" +
                ", cashIssued=null" +
                ", bankReceived=null" +
                ", bankIssued=null" +
                ", businessReceived=1.27" +
                ", notBusinessReceived=1.26" +
                ", totalReceived=2.53" +
                ", businessIssued=null" +
                ", notBusinessIssued=null" +
                ", totalIssued=null" +
                ", attitudeForBusiness=50" +
                ", registrationTime=2021-12-30}";
        assertEquals(expectedValue,transForReport.toString());
    }
}