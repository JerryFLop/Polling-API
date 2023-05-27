package com.pollingapi.jeremiahpollapi.model;

import javax.persistence.*;

@Entity
public class Vote {
 @Id
 @GeneratedValue
 @Column(name="VOTE_ID")
    private long id;
 @ManyToOne
 @JoinColumn(name="OPTION_ID")
    private Option option;

    public Vote() {
    }

    public Vote(long id, Option option) {
        this.id = id;
        this.option = option;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
