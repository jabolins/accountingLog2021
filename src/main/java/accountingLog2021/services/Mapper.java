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

        trans.setDate(transaction.getDate().toString());
        trans.setDocNr(transaction.getTransactionDocNr());
        trans.setPartner(transaction.getTransactionPartner());
        trans.setTransDescription(transaction.getTransactionDescription());

        if (transaction.getBankCash().equals("CASH")) {
            if (transaction.getSum() < 0) {
                trans.setCashIssued(Math.abs(transaction.getSum()));
            }
            if (transaction.getSum() > 0) {
                trans.setCashReceived(transaction.getSum());
            }
        }

        if (transaction.getBankCash().equals("BANK")) {
            if (transaction.getSum() < 0) {
                trans.setBankIssued(Math.abs(transaction.getSum()));
            }
            if (transaction.getSum() > 0) {
                trans.setBankReceived(transaction.getSum());
            }
        }

        if (transaction.getSum() > 0) {
            if (transaction.getAttitudeForBusiness() > 0) {
                trans.setBusinessReceived(rounding
                        (transaction.getSum() * transaction.getAttitudeForBusiness() / 100));
                trans.setNotBusinessReceived(transaction.getSum()
                        - (rounding(transaction.getSum() * transaction.getAttitudeForBusiness() / 100)));
                trans.setTotalReceived(transaction.getSum());
            }
        }

        if (transaction.getSum() < 0) {
            if (transaction.getAttitudeForBusiness() > 0) {
                trans.setBusinessIssued(rounding
                        (Math.abs(transaction.getSum()) * transaction.getAttitudeForBusiness() / 100));
                trans.setNotBusinessIssued((Math.abs(transaction.getSum()) -
                        (rounding(Math.abs(transaction.getSum()) * transaction.getAttitudeForBusiness() / 100))));
                trans.setTotalIssued(Math.abs(transaction.getSum()));
            }
        }

        trans.setAttitudeForBusiness(transaction.getAttitudeForBusiness());

        trans.setRegistrationTime(
                Instant.ofEpochMilli(transaction.getRegTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
        return trans;
    }

    private double rounding(double number) {
        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd= bd.setScale(2, RoundingMode.HALF_DOWN);

        return bd.doubleValue();
    }

}
