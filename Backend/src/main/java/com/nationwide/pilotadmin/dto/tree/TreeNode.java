package com.nationwide.pilotadmin.dto.tree;

import com.nationwide.pilotadmin.dto.frontend.LabelFrontend;
import com.nationwide.pilotadmin.dto.frontend.StateFrontend;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by desair4 on 10/26/2018.
 */
@Data
@Builder
public class TreeNode {
    @EqualsAndHashCode.Exclude
    List<TreeNode> children;        //this will be populated during tree building process

    //Tree data
    @EqualsAndHashCode.Exclude
    int level;                      //this will be populated during tree building process

    //Data
    private String name;            //name comes from Node if on level=0, else comes from label

    @EqualsAndHashCode.Exclude
    List<LabelFrontend> labels;     //this will be populated during tree building process
    @EqualsAndHashCode.Exclude
    StateFrontend state;    //state is only valid if the currentNode is at Level 0
}
