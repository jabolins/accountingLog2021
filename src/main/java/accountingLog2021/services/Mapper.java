package accountingLog2021.services;

import accountingLog2021.domain.Transaction;
import accountingLog2021.models.TransForReport;
import accountingLog2021.models.TransactionFromWeb;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

@Service
public class Mapper {

    public Transaction mapTransactionFromWeb(TransactionFromWeb transIn) {
        Transaction trans = new Transaction();

        trans.setSum(transIn.getSum());
        trans.setTransactionDocNr(transIn.getTransactionDocNr());
        trans.setTransactionPartner(transIn.getTransactionPartner());
        trans.setTransactionDescription(transIn.getTransactionDescription());
        trans.setBankCash(transIn.getBankCash());
        trans.setAttitudeForBusiness(transIn.getAttitudeForBusiness());
        trans.setRegTime(Calendar.getInstance().getTimeInMillis());

        trans.setDate(Date.valueOf(transIn.getDate())); // TODO te vēl vajag pārbaudi vai atsūtītais ir pēc standarta yyyy-MM-dd

        System.out.println(trans);// TODO tas pagaidām pārbaudei

        return trans;
    }

    public TransForReport mapTransactionFromSQL(Transaction transaction) { // TODO jāpārtaisa uz BIgDecimal visu
        TransForReport trans = new TransForReport();

        BigDecimal sumOfTrans = new BigDecimal(Double.toString(transaction.getSum())).abs();
        BigDecimal attitudeForBusiness= new BigDecimal(Double.toString
                (transaction.getAttitudeForBusiness()))
                .divide(BigDecimal.valueOf(100));

        BigDecimal sumWithAttitude = new BigDecimal(String.valueOf
                (sumOfTrans.multiply(attitudeForBusiness))).setScale(2,RoundingMode.HALF_UP);

        trans.setDate(transaction.getDate().toString());
        trans.setDocNr(transaction.getTransactionDocNr());
        trans.setPartner(transaction.getTransactionPartner());
        trans.setTransDescription(transaction.getTransactionDescription());

        if (transaction.getBankCash().equals("CASH")) {
            if (transaction.getSum() < 0) {
                trans.setCashIssued(sumOfTrans);
            }
            if (transaction.getSum() > 0) {
                trans.setCashReceived(sumOfTrans);
            }
        }

        if (transaction.getBankCash().equals("BANK")) {
            if (transaction.getSum() < 0) {
                trans.setBankIssued(sumOfTrans);
            }
            if (transaction.getSum() > 0) {
                trans.setBankReceived(sumOfTrans);
            }
        }

        if (transaction.getSum() > 0) {
            if (transaction.getAttitudeForBusiness() > 0) {
                trans.setBusinessReceived(sumWithAttitude);
                trans.setNotBusinessReceived(sumOfTrans.subtract(sumWithAttitude));
                trans.setTotalReceived(sumOfTrans);
            }
        }

        if (transaction.getSum() < 0) {
            if (transaction.getAttitudeForBusiness() > 0) {
                trans.setBusinessIssued(sumWithAttitude);
                trans.setNotBusinessIssued(sumOfTrans.subtract(sumWithAttitude));
                trans.setTotalIssued(sumOfTrans);
            }
        }

        trans.setAttitudeForBusiness(transaction.getAttitudeForBusiness());
        trans.setRegistrationTime(
                Instant.ofEpochMilli(transaction.getRegTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
        return trans;
    }

}
