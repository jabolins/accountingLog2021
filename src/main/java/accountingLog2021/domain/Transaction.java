package accountingLog2021.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Transaction")
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "transactionDate", nullable = false)
    private Date date;

    @Column(name = "transactionDocNr", length = 100)
    private String transactionDocNr;

    @Column(name = "transactionPartner", length = 100)
    private String transactionPartner;

    @Column(name = "transactionDescription", nullable = false, length = 100)
    private String transactionDescription;

    @Column(name = "sum", nullable = false)
    private double sum;

    @Column(name = "bank_cash", nullable = false, length = 10)
    private String bankCash;

    @Column(name= "attitude_for_business")
    private int attitudeForBusiness;

    @Column(name = "registration_time_ms", nullable = false)
    private long regTime;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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

    public long getRegTime() {
        return regTime;
    }

    public void setRegTime(long regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", transactionDocNr='" + transactionDocNr + '\'' +
                ", transactionPartner='" + transactionPartner + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", sum=" + sum +
                ", bankCash='" + bankCash + '\'' +
                ", attitudeForBusiness=" + attitudeForBusiness +
                ", regTime=" + regTime +
                '}';
    }
}
