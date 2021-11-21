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

    @Column(name = "cashReceived")
    private Double cashReceived;

    @Column(name ="cashIssued")
    private Double cashIssued;

    @Column (name ="bankReceived")
    private Double bankReceived;

    @Column (name= "bankIssued")
    private Double bankIssued;

    @Column (name= "taxableIncome")
    private Double taxableIncome;

    @Column (name= "notTaxableIncome")
    private Double notTaxableIncome;

    @Column (name= "totalIncome")
    private Double totalIncome;

    @Column (name = "businessExpenses")
    private Double businessExpenses;

    @Column (name= "notBusinessExpenses")
    private Double notBusinessExpenses;

    @Enumerated (EnumType.STRING)
    @Column (name= "attitudeForBusiness")
    private AttitudeForBusiness attitudeForBusiness;

}
