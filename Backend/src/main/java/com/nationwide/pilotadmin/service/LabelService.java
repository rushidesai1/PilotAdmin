package com.nationwide.pilotadmin.service;

import com.nationwide.pilotadmin.dao.LabelDao;
import com.nationwide.pilotadmin.dao.PilotDao;
import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.dto.tree.TreeNode;
import com.nationwide.pilotadmin.mappers.LabelMapper;
import com.nationwide.pilotadmin.mappers.TreeNodeMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        List<Label> level0Labels = labelsByName.stream()
                .filter(LabelService::isLevelZero)
                .collect(Collectors.toList());  //Level zero labels are pilots.

        List<Node> level0Pilots = pilotDao.findAllByLabelsIn(level0Labels); //find all pilots which match level0Labels.

        List<TreeNode> treeNodes = TreeNodeMapper.mapLabelsToTreeNodes(labelsByName);   //use pilots to get 'state'

        TreeNodeMapper.mergeState(treeNodes, level0Pilots); //this will transfer 'State' information to TreeNodes

        return treeNodes;
    }

    private static boolean isLevelZero(Label label) {
        return label.getLevel() == 0;
    }


/*    List<TreeNode> findAll() {


    }*/

}
