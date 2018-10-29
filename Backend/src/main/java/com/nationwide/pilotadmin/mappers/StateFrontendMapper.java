package com.nationwide.pilotadmin.mappers;

import com.nationwide.pilotadmin.domain.State;
import com.nationwide.pilotadmin.dto.frontend.StateFrontend;

/**
 * Created by desair4 on 10/26/2018.
 */
public class StateFrontendMapper {

    private StateFrontendMapper() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static StateFrontend mapStateToStateFrontend(State state) {
        if (state == null) return null;

        return StateFrontend.builder()
                .isPilotOn(state.isPilotOn())
                .build();
    }
}
