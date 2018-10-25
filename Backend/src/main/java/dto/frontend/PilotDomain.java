package dto.frontend;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.State;
import lombok.Data;

import java.util.Set;

/**
 * @author rushidesai
 */
@Data
public class PilotDomain {
    private long id;
    private String name;
    State state;
    private Set<Label> labels;
}
