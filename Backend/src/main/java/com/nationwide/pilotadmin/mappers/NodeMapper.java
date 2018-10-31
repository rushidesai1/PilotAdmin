package com.nationwide.pilotadmin.mappers;

import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.dto.tree.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rushidesai
 */
public class NodeMapper {

    private NodeMapper() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static List<Node> mapTreeNodesToNodes(List<TreeNode> treeNodes) {
        if (treeNodes == null) return Collections.emptyList();

        return treeNodes.stream()
                .map(NodeMapper::mapTreeNodeToNode)
                .collect(Collectors.toList());
    }

    public static Node mapTreeNodeToNode(TreeNode treeNode) {
        if (treeNode == null) return null;
        return Node.builder()
                .state(StateMapper.mapStateFrontendToState(treeNode.getState()))
                .name(treeNode.getName())
//                .labels(new HashSet<>(LabelMapper.mapLabelFrontendsToLabels(treeNode.getLabels())))
                .build();
    }



   /* public static List<Node> mapTreeNodesToNodes(List<TreeNode> treeNodes) {
        if (treeNodes == null) return Collections.emptyList();

        return treeNodes.stream()
                .map(NodeMapper::mapTreeNodeToNode)
                .collect(Collectors.toList());
    }

    public static Node mapTreeNodeToNode(TreeNode treeNode) {
        if (treeNode == null) return null;

        return Node.builder()
                .name(treeNode.getName())
                .state(St)
                .build();

    }*/


}
