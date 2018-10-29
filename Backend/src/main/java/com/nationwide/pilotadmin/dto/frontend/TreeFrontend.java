package com.nationwide.pilotadmin.dto.frontend;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author rushidesai on 10/26/2018.
 */
@Data
@Builder
public class TreeFrontend {

    private List<TreeFrontend> treeNodes;

//    private List<List<TreeFrontend>> labelsRows;
}
