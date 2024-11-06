package org.example.module_three.model;
import java.util.Date;

public class Room {
    private int roomId;
    private String renterName;
    private String renterPhoneNumber;
    private Date rentStartDate;
    private int paymentMethodId;
    private String PaymentMethodName;
    private String note;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getRenterPhoneNumber() {
        return renterPhoneNumber;
    }

    public void setRenterPhoneNumber(String renterPhoneNumber) {
        this.renterPhoneNumber = renterPhoneNumber;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymentMethodName() {
        return PaymentMethodName;
    }

    public void setPaymentMethodName(String PaymentMethodName) {
        this.PaymentMethodName = PaymentMethodName;
    }

}
