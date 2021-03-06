package com.ridgue.homefood.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_restaurant")
@Data
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_id", nullable = false)
    private KitchenEntity kitchen;

    @Column(name = "shipping", nullable = false)
    private BigDecimal shipping;

    @Embedded
    private Address address;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate created;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate lastUpdate;

    @ManyToMany
    @JoinTable(name = "restaurant_payment_method",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id"))
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<ProductEntity> products = new ArrayList<>();
}
