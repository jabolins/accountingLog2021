package accountingLog2021.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

public class TransForReport {
    private Long id;
    private String date;
    private String docNr;
    private String partner;
    private String transDescription;
    private BigDecimal cashReceived;
    private BigDecimal cashIssued;
    private BigDecimal bankReceived;
    private BigDecimal bankIssued;
    private BigDecimal businessReceived;
    private BigDecimal notBusinessReceived;
    private BigDecimal totalReceived;
    private BigDecimal businessIssued;
    private BigDecimal notBusinessIssued;
    private BigDecimal totalIssued;
    private int attitudeForBusiness;
    private LocalDate registrationTime;


    public TransForReport() {
    }

    public Long getId() {
        return id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDocNr() {
        return docNr;
    }

    public void setDocNr(String docNr) {
        this.docNr = docNr;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getTransDescription() {
        return transDescription;
    }

    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription;
    }

    public BigDecimal getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(BigDecimal cashReceived) {
        this.cashReceived = cashReceived;
    }

    public BigDecimal getCashIssued() {
        return cashIssued;
    }

    public void setCashIssued(BigDecimal cashIssued) {
        this.cashIssued = cashIssued;
    }

    public BigDecimal getBankReceived() {
        return bankReceived;
    }

    public void setBankReceived(BigDecimal bankReceived) {
        this.bankReceived = bankReceived;
    }

    public BigDecimal getBankIssued() {
        return bankIssued;
    }

    public void setBankIssued(BigDecimal bankIssued) {
        this.bankIssued = bankIssued;
    }

    public BigDecimal getBusinessReceived() {
        return businessReceived;
    }

    public void setBusinessReceived(BigDecimal businessReceived) {
        this.businessReceived = businessReceived;
    }

    public BigDecimal getNotBusinessReceived() {
        return notBusinessReceived;
    }

    public void setNotBusinessReceived(BigDecimal notBusinessReceived) {
        this.notBusinessReceived = notBusinessReceived;
    }

    public BigDecimal getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(BigDecimal totalReceived) {
        this.totalReceived = totalReceived;
    }

    public BigDecimal getBusinessIssued() {
        return businessIssued;
    }

    public void setBusinessIssued(BigDecimal businessIssued) {
        this.businessIssued = businessIssued;
    }

    public BigDecimal getNotBusinessIssued() {
        return notBusinessIssued;
    }

    public void setNotBusinessIssued(BigDecimal notBusinessIssued) {
        this.notBusinessIssued = notBusinessIssued;
    }

    public BigDecimal getTotalIssued() {
        return totalIssued;
    }

    public void setTotalIssued(BigDecimal totalIssued) {
        this.totalIssued = totalIssued;
    }

    public int getAttitudeForBusiness() {
        return attitudeForBusiness;
    }

    public void setAttitudeForBusiness(int attitudeForBusiness) {
        this.attitudeForBusiness = attitudeForBusiness;
    }

    public LocalDate getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDate registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public String toString() {
        return "TransForReport{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", docNr='" + docNr + '\'' +
                ", partner='" + partner + '\'' +
                ", transDescription='" + transDescription + '\'' +
                ", cashReceived=" + cashReceived +
                ", cashIssued=" + cashIssued +
                ", bankReceived=" + bankReceived +
                ", bankIssued=" + bankIssued +
                ", businessReceived=" + businessReceived +
                ", notBusinessReceived=" + notBusinessReceived +
                ", totalReceived=" + totalReceived +
                ", businessIssued=" + businessIssued +
                ", notBusinessIssued=" + notBusinessIssued +
                ", totalIssued=" + totalIssued +
                ", attitudeForBusiness=" + attitudeForBusiness +
                ", registrationTime=" + registrationTime +
                '}';
    }
}
