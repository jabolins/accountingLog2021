package accountingLog2021.models;

import java.time.LocalDate;
import java.util.Calendar;

public class TransForReport {
    private Long id;
    private String date;
    private String docNr;
    private String partner;
    private String transDescription;
    private double cashReceived;
    private double cashIssued;
    private double bankReceived;
    private double bankIssued;
    private double businessReceived;
    private double notBusinessReceived;
    private double totalReceived;
    private double businessIssued;
    private double notBusinessIssued;
    private double totalIssued;
    private int attitudeForBusiness;
    private LocalDate registrationTime;

    public TransForReport(String date
            , String docNr
            , String partner
            , String transDescription
            , double cashReceived
            , double cashIssued
            , double bankReceived
            , double bankIssued
            , double businessReceived
            , double notBusinessReceived
            , double totalReceived
            , double businessIssued
            , double notBusinessIssued
            , double totalIssued
            , int attitudeForBusiness
            , LocalDate registrationTime) {
        this.date = date;
        this.docNr = docNr;
        this.partner = partner;
        this.transDescription = transDescription;
        this.cashReceived = cashReceived;
        this.cashIssued = cashIssued;
        this.bankReceived = bankReceived;
        this.bankIssued = bankIssued;
        this.businessReceived = businessReceived;
        this.notBusinessReceived = notBusinessReceived;
        this.totalReceived = totalReceived;
        this.businessIssued = businessIssued;
        this.notBusinessIssued = notBusinessIssued;
        this.totalIssued = totalIssued;
        this.attitudeForBusiness = attitudeForBusiness;
        this.registrationTime = registrationTime;
    }

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

    public double getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public double getCashIssued() {
        return cashIssued;
    }

    public void setCashIssued(double cashIssued) {
        this.cashIssued = cashIssued;
    }

    public double getBankReceived() {
        return bankReceived;
    }

    public void setBankReceived(double bankReceived) {
        this.bankReceived = bankReceived;
    }

    public double getBankIssued() {
        return bankIssued;
    }

    public void setBankIssued(double bankIssued) {
        this.bankIssued = bankIssued;
    }

    public double getBusinessReceived() {
        return businessReceived;
    }

    public void setBusinessReceived(double businessReceived) {
        this.businessReceived = businessReceived;
    }

    public double getNotBusinessReceived() {
        return notBusinessReceived;
    }

    public void setNotBusinessReceived(double notBusinessReceived) {
        this.notBusinessReceived = notBusinessReceived;
    }

    public double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(double totalReceived) {
        this.totalReceived = totalReceived;
    }

    public double getBusinessIssued() {
        return businessIssued;
    }

    public void setBusinessIssued(double businessIssued) {
        this.businessIssued = businessIssued;
    }

    public double getNotBusinessIssued() {
        return notBusinessIssued;
    }

    public void setNotBusinessIssued(double notBusinessIssued) {
        this.notBusinessIssued = notBusinessIssued;
    }

    public double getTotalIssued() {
        return totalIssued;
    }

    public void setTotalIssued(double totalIssued) {
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
