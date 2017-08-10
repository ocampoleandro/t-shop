package com.example.leandroocampo.t_shop.common.model;

import org.parceler.Parcel;

/**
 * Base entity for most of model objects
 */
@Parcel(Parcel.Serialization.BEAN)
public class BaseEntity {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
