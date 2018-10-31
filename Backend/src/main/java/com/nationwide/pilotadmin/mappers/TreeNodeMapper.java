package com.nationwide.pilotadmin.mappers;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.dto.frontend.StateFrontend;
import com.nationwide.pilotadmin.dto.tree.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by desair4 on 10/26/2018.
 */
public class TreeNodeMapper {

    private TreeNodeMapper() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static List<TreeNode> mapNodesToTreeNodes(final List<Node> nodes) {
        if (nodes == null) return Collections.emptyList();

        return nodes.stream()
                .map(TreeNodeMapper::mapNodeToTreeNode)
                .collect(Collectors.toList());
    }


    public static TreeNode mapNodeToTreeNode(Node node) {
        if (node == null) return null;

        return TreeNode.builder()
//                .level(node.getLevel())
                .state(StateFrontendMapper.mapStateToStateFrontend(node.getState()))
                .name(node.getName())
                .labels(LabelFrontendMapper.mapLabelsToLabelFrontends(node.getLabels()))
                .build();
    }

    public static List<TreeNode> mapNodesNoLabelsToTreeNodes(final List<Node> nodes) {
        if (nodes == null) return Collections.emptyList();

        return nodes.stream()
                .map(TreeNodeMapper::mapNodeNoLabelsToTreeNode)
                .collect(Collectors.toList());
    }

    public static TreeNode mapNodeNoLabelsToTreeNode(Node node) {
        if (node == null) return null;

        return TreeNode.builder()
//                .level(node.getLevel())
                .state(StateFrontendMapper.mapStateToStateFrontend(node.getState()))
                .name(node.getName())
//                .labels(LabelFrontendMapper.mapLabelsToLabelFrontends(node.getLabels()))
                .build();
    }

    public static List<TreeNode> mapLabelsToTreeNodes(List<Label> labels) {
        if (labels == null) return Collections.emptyList();

        return labels.stream()
                .map(TreeNodeMapper::mapLabelToTreeNode)
                .collect(Collectors.toList());
    }

    public static List<TreeNode> mapLabelsSetToTreeNodes(Set<Label> labels) {
        if (labels == null) return Collections.emptyList();

        return labels.stream()
                .map(TreeNodeMapper::mapLabelToTreeNode)
                .collect(Collectors.toList());
    }

    public static TreeNode mapLabelToTreeNode(Label label) {
        if (label == null) return null;
        return TreeNode.builder()
                .name(label.getName())
                .level(label.getLevel())
                .build();
    }


    public static List<TreeNode> mergeState(List<TreeNode> treeNodes, List<Node> pilots) {
        if (treeNodes == null) return Collections.emptyList();
        if (pilots == null) return treeNodes;
        if (pilots.isEmpty()) return treeNodes;

        //convert to easier data-structure.
        Map<String, Node> nameNodeMap = pilots.stream()
                .collect(Collectors.toMap(Node::getName, node -> node));

        //
        treeNodes.stream()
                .filter((treeNode) -> isTreeNodePilot(treeNode, nameNodeMap))   //only need those treeNodes which are pilot.
                .forEach((treeNode -> mergeState(treeNode, nameNodeMap)));
//                .map((treeNode -> mergeState(treeNode, nameNodeMap)))
//                .collect(Collectors.toList());

        return treeNodes;
    }

    private static boolean isTreeNodePilot(TreeNode treeNode, Map<String, Node> nameNodeMap) {
        return nameNodeMap.get(treeNode.getName()) != null;
    }

    private static void mergeState(TreeNode treeNode, Map<String, Node> nameNodeMap) {
        StateFrontend stateFrontend = StateFrontendMapper.mapStateToStateFrontend(nameNodeMap.get(treeNode.getName()).getState());
        treeNode.setState(stateFrontend);
    }

}
