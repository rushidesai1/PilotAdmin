package com.nationwide.pilotadmin.mappers;

import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.dto.tree.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by desair4 on 10/26/2018.
 */
public class NodeMapper {

    private NodeMapper() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static List<TreeNode> mapNodesToTreeNodes(final List<Node> nodes) {
        if (nodes == null) return Collections.emptyList();

        return nodes.stream()
                .map(NodeMapper::mapNodeToTreeNode)
                .collect(Collectors.toList());
    }

    public static TreeNode mapNodeToTreeNode(Node node) {
        if (node == null) return null;

        return TreeNode.builder()
//                .level(node.getLevel())
                .state(StateMapper.mapStateToStateFrontend(node.getState()))
                .name(node.getName())
                .labels(LabelMapper.mapLabelsToLabelFrontends(node.getLabels()))
                .build();
    }
}
