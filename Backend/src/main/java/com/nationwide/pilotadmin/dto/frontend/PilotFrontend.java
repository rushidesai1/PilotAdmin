package com.nationwide.pilotadmin.dto.frontend;

import com.nationwide.pilotadmin.domain.State;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author rushidesai
 */
@Data
public class PilotFrontend {

    private long id;
    private String name;
    int level;

    @EqualsAndHashCode.Exclude
    State state;
    @EqualsAndHashCode.Exclude
    private Set<LabelFrontend> labels;
}
