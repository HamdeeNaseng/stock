package com.jsp.stock.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Items {
    public Items() {
        
    }

    public Items(long id2, String itemName2, int itemPrice2, int itemQuantity2, String itemDescription2, String itemStatus2, String itemImageUrl2) {
        this.id = id2;
        this.itemName = itemName2;
        this.itemPrice = itemPrice2;
        this.itemQuantity = itemQuantity2;
        this.itemDescription = itemDescription2;
        this.itemStatus = itemStatus2;
        this.itemImageUrl = itemImageUrl2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private int itemPrice;

    @Column(name = "item_quantity")
    private int itemQuantity;

    @Column(name = "item_description", columnDefinition = "TEXT")
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "category_item_id")
    @Nullable
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_item_id", referencedColumnName = "id")
    private User author;
    
    @Column(name = "item_status")
    private String itemStatus;

    @Column(name = "item_image_url")
    
    private String itemImageUrl;

    @Column(name = "item_created")
    private LocalDateTime itemCreated;

    @Column(name = "item_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime itemUpdated;


    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", itemName:'" + itemName + '\'' +
                ", itemPrice:" + itemPrice +
                ", itemQuantity:" + itemQuantity +
                ", itemDescription:'" + itemDescription + '\'' +
                ", category:" + (category != null ? category.getId() : null) +
                ", author:" + (author != null ? author.getId() : null) +
                ", itemStatus:'" + itemStatus + '\'' +
                ", itemImageUrl:'" + itemImageUrl + '\'' +
                ", itemCreated:" + itemCreated +
                ", itemUpdated:" + itemUpdated +
                '}';
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setImageUrl(String filename) {
        this.itemImageUrl = filename;
    }
}
