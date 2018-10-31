package com.nationwide.pilotadmin.service;

import com.nationwide.pilotadmin.dao.PilotDao;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.dto.frontend.PilotFrontend;
import com.nationwide.pilotadmin.dto.tree.TreeNode;
import com.nationwide.pilotadmin.mappers.NodeMapper;
import com.nationwide.pilotadmin.mappers.TreeNodeMapper;
import com.nationwide.pilotadmin.tree.TreeConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author rushidesai
 */
@Data
@Service
public class PilotService {
    @Autowired
    private PilotDao pilotDao;

    boolean addPilot(PilotFrontend pilotDomain) {
//        Node pilot1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();
//        Node pilot2 = Node.builder().name("CARD_2").state(State.builder().isPilotOn(true).build()).build();
////        Node pilot1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();
//
//        Label label1 = Label.builder().name("CARD_1").level(1).build();
//        Label label2 = Label.builder().name("FEAT_1").level(2).build();
//        Label label3 = Label.builder().name("PROJ_1").level(3).build();
//        Label label4 = Label.builder().name("CARD_2").level(1).build();
//        Label label5 = Label.builder().name("FEAT_2").level(2).build();
//        Label label6 = Label.builder().name("PROJ_2").level(3).build();
//
//        List<Node> nodes = new ArrayList<>();
//        List<Label> labels = new ArrayList<>();
//        labels.add(label1);
//
//        nodes.add(pilot1);
////        nodes.add(pilot2);
////        nodes.add(pilot3);
//
//        pilotRepository.saveAll(nodes);

        return true;

    }

    public List<TreeNode> findAll() {
        Iterable<Node> all = pilotDao.findAll();
        List<Node> nodes = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());

        List<TreeNode> treeNodes = TreeNodeMapper.mapNodesToTreeNodes(nodes);

        return TreeConstruct.constructTree(treeNodes);
    }

    public List<TreeNode> fetchPilots(List<TreeNode> nodesTreeNode) {
        if (nodesTreeNode == null) return Collections.emptyList();

//        List<Label> labels = LabelMapper.mapTreeNodesToLabels(nodesTreeNode);
        List<Node> nodesRequest = NodeMapper.mapTreeNodesToNodes(nodesTreeNode);

        List<Node> nodes = pilotDao.findAllByNodesIn(nodesRequest);  //db query
//        List<Node> nodes = pilotDao.findAllByLabel(labels.get(0));  //db query

        List<TreeNode> treeNodes = TreeNodeMapper.mapNodesToTreeNodes(nodes);

        List<TreeNode> rootNodes = TreeConstruct.constructTree(treeNodes);

        return treeNodes;
    }
}
