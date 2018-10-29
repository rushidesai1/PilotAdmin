package com.nationwide.pilotadmin.mappers;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.LabelMetadata;
import com.nationwide.pilotadmin.dto.frontend.LabelFrontend;
import com.nationwide.pilotadmin.dto.tree.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rushidesai
 */
public class LabelMapper {

    private LabelMapper() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static List<Label> mapTreeNodesToLabels(List<TreeNode> treeNodes) {
        if (treeNodes == null) return Collections.emptyList();

        return treeNodes.stream()
                .map(LabelMapper::mapTreeNodeToLabel)
                .collect(Collectors.toList());
    }

    public static Label mapTreeNodeToLabel(TreeNode treeNode) {
        if (treeNode == null) return null;

        return Label.builder()
                .name(treeNode.getName())
                .build();

    }

    public static List<Label> mapLabelFrontendsToLabels(List<LabelFrontend> labelFrontends) {
        if (labelFrontends == null) return Collections.emptyList();

        return labelFrontends.stream()
                .map(LabelMapper::mapLabelFrontendToLabel)
                .collect(Collectors.toList());
    }


    public static Label mapLabelFrontendToLabel(LabelFrontend labelFrontend) {
        if (labelFrontend == null) return null;

        return Label.builder()
                .level(labelFrontend.getLevel())
                .name(labelFrontend.getName())
                .labelMetadata(LabelMetadata.builder().description(labelFrontend.getDescription()).build())
                .build();
    }

}
