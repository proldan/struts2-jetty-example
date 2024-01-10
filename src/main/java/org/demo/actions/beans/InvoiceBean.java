package org.demo.actions.beans;

import java.math.RoundingMode;
import java.util.Date;
import java.math.BigDecimal;

public class InvoiceBean {

    private String subject;
    private Date dateFrom;
    private Date dateTo;
    private String price;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        if (!price.isEmpty()) {
            BigDecimal bd = this.getAmount();
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            bd = bd.multiply(new BigDecimal("0.21"));
            return bd;
        } else {
            return null;
        }
    }

    public BigDecimal getTotal() {
        if (price != null) {
            BigDecimal bd = this.getAmount();
            bd = bd.add(this.getVat());
            bd.setScale(2, RoundingMode.HALF_UP);
            return bd;
        } else {
            return  null;
        }
    }

    public BigDecimal getAmount() {
        if (price != null) {
            return new BigDecimal(price);
        } else {
            return null;
        }
    }
}
