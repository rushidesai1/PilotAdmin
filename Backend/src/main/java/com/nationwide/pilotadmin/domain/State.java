package com.nationwide.pilotadmin.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author rushidesai
 */
@Data
@Builder
@Entity
public class State {

    @Column
    @Id
    @GeneratedValue
    private long id;

//    @Column
//    private long entityID;

    @Column
    private boolean isPilotOn;
}
