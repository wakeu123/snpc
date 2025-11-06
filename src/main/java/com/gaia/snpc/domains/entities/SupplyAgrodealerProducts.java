package com.gaia.snpc.domains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUPPLY_AGRODEALER_PRODUCTS")
@Entity(name = "SupplyAgrodealerProducts")
public class SupplyAgrodealerProducts extends BaseEntity{

    private Boolean active;
    private String saleUnit;
    private String photoUrl;
    private String productName;
    private String productKind;
    private String compatibleCrops;
    private String shortDescription;
    private BigDecimal unitPriceFcfa;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(
            nullable = false,
            name = "agrodealer_id",
            referencedColumnName = "id")
    private SupplyAgroDealers agroDealer;
}
