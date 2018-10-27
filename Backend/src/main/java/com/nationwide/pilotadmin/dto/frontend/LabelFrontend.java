package com.nationwide.pilotadmin.dto.frontend;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by desair4 on 10/26/2018.
 */
@Data
@Builder
public class LabelFrontend {
    private long id;
    private String name;
    int level;

    /*@EqualsAndHashCode.Exclude
    State state;
    @EqualsAndHashCode.Exclude
    private Set<LabelFrontend> labels;*/
    @EqualsAndHashCode.Exclude
    private String description;
}
