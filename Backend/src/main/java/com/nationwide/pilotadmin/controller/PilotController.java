package com.nationwide.pilotadmin.controller;

import com.nationwide.pilotadmin.dto.tree.TreeNode;
import com.nationwide.pilotadmin.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rushidesai
 */
@RestController
@RequestMapping("pilots")
public class PilotController {


    @Autowired
    PilotService pilotService;

    @GetMapping("test")
    public String test() {
        return "Test good";
    }


    @GetMapping
    Flux<TreeNode> findAll() {
        List<TreeNode> all = pilotService.findAll();
        if (all == null) {
            all = Collections.emptyList();
        }
        return Flux.fromIterable(all);
    }

    @GetMapping("{name}")
    Flux<TreeNode> findByName(@PathVariable("name") String name) {
        List<TreeNode> labelsTreeNode = new ArrayList<>();

        TreeNode treeNode = TreeNode.builder()
                .name(name)
                .build();
        labelsTreeNode.add(treeNode);
        List<TreeNode> treeNodes = pilotService.fetchPilots(labelsTreeNode);

        if (treeNodes == null) treeNodes = Collections.emptyList();

        return Flux.fromIterable(treeNodes);
    }

}
