package com.example.jure_lokovsek.greendao_app.DataBase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Nutrient implements Serializable{

    static final long serialVersionUID = 53648515871008L;

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String nutrient;
    @NotNull
    private String value;
    @NotNull
    private String unit;

    @Keep
    public Nutrient(String nutrient, String value, String unit) {
        this.nutrient = nutrient;
        this.value = value;
        this.unit = unit;
    }

    @Generated(hash = 670038411)
    public Nutrient(Long id, @NotNull String nutrient, @NotNull String value,
            @NotNull String unit) {
        this.id = id;
        this.nutrient = nutrient;
        this.value = value;
        this.unit = unit;
    }
    @Generated(hash = 245651425)
    public Nutrient() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNutrient() {
        return this.nutrient;
    }
    public void setNutrient(String nutrient) {
        this.nutrient = nutrient;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getUnit() {
        return this.unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    


}
