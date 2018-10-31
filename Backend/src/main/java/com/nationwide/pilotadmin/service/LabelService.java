package com.nationwide.pilotadmin.service;

import com.nationwide.pilotadmin.dao.LabelDao;
import com.nationwide.pilotadmin.dao.PilotDao;
import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.dto.tree.TreeNode;
import com.nationwide.pilotadmin.mappers.LabelMapper;
import com.nationwide.pilotadmin.mappers.TreeNodeMapper;
import com.nationwide.pilotadmin.tree.TreeConstruct;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rushidesai
 */
@Service
@Log
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private PilotDao pilotDao;

//    boolean attachLabels(Label label1, Label label2) {
//        boolean add = label1.getLabels().add(label2);
//        labelRepository.save(label1);
//        return true;
//    }

    public List<TreeNode> findLabelsByName(List<TreeNode> labelNodes) {
        List<Label> labels = LabelMapper.mapTreeNodesToLabels(labelNodes);
//        List<Node> labelsNodes = NodeMapper.mapTreeNodesToNodes(labelNodes);

        List<Label> labelsByName = labelDao.findLabelsByName(labels);
//        List<Node> labelsByNamePilot = pilotDao.findAllByLabelsIn(labels);

        final List<Set<Node>> temp = labelsByName.stream()
                .map(Label::getNodes)
                .collect(Collectors.toList());

        final List<Node> pilotsNodesFlattened = temp.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        final List<Node> pilotNodes = pilotDao.findAllByNodesIn(pilotsNodesFlattened);


        final Set<Label> allLabelsSet = pilotNodes.stream().map(Node::getLabels).collect(Collectors.toList()).stream().flatMap(Collection::stream).collect(Collectors.toSet());
//        List<Node> level0Pilots = pilotDao.findAllByLabelsIn(pilotsNodes); //find all pilots which match level0Labels.
//        List<Node> level0Pilots = Collections.emptyList();
        final List<Label> level0FilteredLabels = allLabelsSet.stream()
                .filter(LabelService::isNotLevelZero)
                .collect(Collectors.toList());

        List<TreeNode> labelTreeNodes = TreeNodeMapper.mapLabelsToTreeNodes(level0FilteredLabels);   //use pilots to get 'state'
        List<TreeNode> pilotTreeNodes = TreeNodeMapper.mapNodesNoLabelsToTreeNodes(pilotNodes);   //use pilots to get 'state'

//        TreeNodeMapper.mergeState(treeNodes, level0Pilots); //this will transfer 'State' information to TreeNodes
        List<TreeNode> finalTreeNodes = new ArrayList<>();
        finalTreeNodes.addAll(labelTreeNodes);
        finalTreeNodes.addAll(pilotTreeNodes);

        List<TreeNode> rootNodes = TreeConstruct.constructTree(finalTreeNodes);

        return finalTreeNodes;
    }

    private static boolean isNotLevelZero(Label label) {
        return label.getLevel() != 0;
    }


/*    List<TreeNode> findAll() {


    }*/

}
