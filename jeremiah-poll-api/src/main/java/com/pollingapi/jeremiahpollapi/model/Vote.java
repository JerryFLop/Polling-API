package com.pollingapi.jeremiahpollapi.model;

import javax.persistence.*;

@Entity
public class Vote {
 @Id
 @GeneratedValue
 @Column(name="VOTE_ID")
    private Long id;
 @ManyToOne// uses a foreign key
 @JoinColumn(name="OPTION_ID")
    private Option option;

    public Vote() {
    }

//    public Vote(Long id, Option option) {
//        this.id = id;
//        this.option = option;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", option=" + option +
                '}';
    }
}
