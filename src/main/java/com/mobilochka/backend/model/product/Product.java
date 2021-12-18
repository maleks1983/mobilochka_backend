package com.mobilochka.backend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilochka.backend.model.AbstractIdEntyty;
import lombok.*;

import javax.persistence.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "product")
public class Product extends AbstractIdEntyty {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_product_id", nullable = false)
    @JsonIgnore
    private Group group;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_product_id", nullable = false)
    @JsonIgnore
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacture_product_id", nullable = false)
    @JsonIgnore
    private Manufactur manufacture;

    @Column(name = "product_name")
    private String name;

    @Column(name = "article")
    private String article;

    @Column(name = "price")
    private Integer price;

    @Column(name = "price_rrc")
    private Integer price_rrc;

    @Column(name = "link")
    private String link;

    @Column(name = "UKTBED")
    private Long uzdk;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "barcodes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "barcode")
    private Set<String> barcode;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image")
    private Set<String> image;


    public Product(Group group, Category category, Manufactur manufacture, String name, String article, int price, int priceRrc, String link, long uzdk, String listBarcode) {
        this.group = group;
        this.category = category;
        this.manufacture = manufacture;
        this.name = name;
        this.article = article;
        this.price = price;
        this.price_rrc = priceRrc;
        this.link = link;
        this.uzdk = uzdk;
        this.setBarcode(listBarcode);

    }

    public void setBarcode(String barcode) {
        this.barcode = new HashSet<>();
        this.barcode.addAll(Arrays.asList(barcode.split(";")));

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
