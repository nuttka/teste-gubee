package com.gubee.teste.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_target_market",
            joinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "target_market_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<TargetMarket> targetMarkets = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_technology",
            joinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "technology_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Technology> technologies = new ArrayList<>();

    @Column(name = "active")
    private Boolean active;


    public Product() {

    }

    public Product(String name, String description, ArrayList<TargetMarket> targetMarkets, ArrayList<Technology> technologies, Boolean active) {
        super();
        this.name = name;
        this.description = description;
        this.targetMarkets = targetMarkets;
        this.technologies = technologies;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TargetMarket> getTargetMarkets() {
        return targetMarkets;
    }

    
    public void setTargetMarkets(ArrayList<TargetMarket> targetMarkets) {
        this.targetMarkets = targetMarkets;
    }
    
    public List<Technology> getTechnologies() {
        return technologies;
    }
    
    public void setTechnologies(ArrayList<Technology> technologies) {
        this.technologies = technologies;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
