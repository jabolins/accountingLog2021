package accountingLog2021.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class TransactionFromWeb {

    private String date;

    private Double sum;

    private String transactionDocNr;

    private String transactionPartner;

    private String transactionDescription;

    private String bankCash;

    private int attitudeForBusiness;

    public TransactionFromWeb(String date
            , Double sum
            , String transactionDocNr
            , String transactionPartner
            , String transactionDescription
            , String bankCash
            , int attitudeForBusiness) {
        this.date = date;
        this.sum = sum;
        this.transactionDocNr = transactionDocNr;
        this.transactionPartner = transactionPartner;
        this.transactionDescription = transactionDescription;
        this.bankCash = bankCash;
        this.attitudeForBusiness = attitudeForBusiness;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getTransactionDocNr() {
        return transactionDocNr;
    }

    public void setTransactionDocNr(String transactionDocNr) {
        this.transactionDocNr = transactionDocNr;
    }

    public String getTransactionPartner() {
        return transactionPartner;
    }

    public void setTransactionPartner(String transactionPartner) {
        this.transactionPartner = transactionPartner;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getBankCash() {
        return bankCash;
    }

    public void setBankCash(String bankCash) {
        this.bankCash = bankCash;
    }

    public int getAttitudeForBusiness() {
        return attitudeForBusiness;
    }

    public void setAttitudeForBusiness(int attitudeForBusiness) {
        this.attitudeForBusiness = attitudeForBusiness;
    }

    @Override
    public String toString() {
        return "TransactionFromWeb{" +
                "date='" + date + '\'' +
                ", sum='" + sum + '\'' +
                ", transactionDocNr='" + transactionDocNr + '\'' +
                ", transactionPartner='" + transactionPartner + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", bankCash='" + bankCash + '\'' +
                ", attitudeForBusiness=" + attitudeForBusiness +
                '}';
    }
}
