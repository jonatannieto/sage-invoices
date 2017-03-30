package com.sage.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jonatannietoa on 29/3/17.
 */
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;

    public Customer() {}

    public Customer(Integer version, String name) {
        this.version = version;
        this.name = name;
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
}
