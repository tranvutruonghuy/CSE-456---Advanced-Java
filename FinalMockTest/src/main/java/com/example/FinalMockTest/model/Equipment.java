package com.example.FinalMockTest.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="tbl_Equipment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Equipment {
    @Id
    @Column(columnDefinition = "CHAR(10)")
    private String equipmentId;

//    @Column(columnDefinition = "INT")
//    private int equipmentTypeId;

    @Column(columnDefinition = "VARCHAR(150)", nullable = false)
    @Size(min = 5, max = 100, message = "Length of name must be between 5 and 100")
    @NotNull(message = "Name must be not null")
    private String equipmentName;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    @Min(value = 1000,message = "Price must be grater than or equal 1000")
    @NotNull(message = "Purchase price date must not be null")
    private double purchasePrice;

    @Column(columnDefinition = "INT", nullable = false)
    @Min(value = 0,message = "Quantity must be at least 0")
    @Max(value = 500,message = "Quantity must be at most 500")
    @NotNull(message = "Quantity date must not be null")
    private int quantityAvailable;

    @NotNull(message = "Purchase date must not be null")
    @CreatedDate
    private LocalDateTime datetime;


    @ManyToOne()
    @JoinColumn(name = "equipmentTypeId")
    private EquipmentType equipmentType;


    public Equipment(String equipmentId, @NotNull(message = "Name must be not null") String equipmentName, @NotNull(message = "Purchase price date must not be null") double purchasePrice, @NotNull(message = "Quantity date must not be null") int quantityAvailable) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.purchasePrice = purchasePrice;
        this.quantityAvailable = quantityAvailable;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
}
