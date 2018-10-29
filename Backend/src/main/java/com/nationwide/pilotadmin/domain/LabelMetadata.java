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
@Builder
@Data
@Entity
public class LabelMetadata {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private long labelId;

    @Column
    private String description;

}
