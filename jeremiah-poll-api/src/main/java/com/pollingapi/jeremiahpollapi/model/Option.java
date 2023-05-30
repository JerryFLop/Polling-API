package com.pollingapi.jeremiahpollapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//POJO- Model

@Entity // Marks a class to be used in a database
public class Option {
    @Id // Used to identify
    @GeneratedValue  // Generate numbers when i add things
    @Column(name="OPTION_ID") // Store it in a column
    private Long id;
    @Column(name="OPTION_VALUE")
    private String value;


//    public Option(Long id, String value) {
//        this.id = id;
//        this.value = value;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
