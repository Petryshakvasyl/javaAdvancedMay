package ua.lviv.lgs.pv.entity;

import java.time.LocalDate;

public class Bucket {

    private Integer id;

    private LocalDate purchaseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
