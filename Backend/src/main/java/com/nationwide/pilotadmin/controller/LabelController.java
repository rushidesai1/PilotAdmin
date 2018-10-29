package com.nationwide.pilotadmin.controller;

import com.nationwide.pilotadmin.dto.tree.TreeNode;
import com.nationwide.pilotadmin.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rushidesai
 */
@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;
//    @Autowired
//    private PilotService pilotService;

    /*  @GetMapping("/labels")
      @ResponseBody
      public Mono<Iterable<Label>> labels() {
  //        Iterable<Label> labels = labelService.findAll();
  //        Iterable<Node> labels = pilotService.findAll();
  //        return Mono.just(labels);
      }
  */
    @GetMapping("/labels/{name}")
    @ResponseBody
    public Flux<TreeNode> search(@PathVariable("name") String name) {
//        Label.LabelBuilder label = Label.builder().name(name);
//        PageRequest pageRequest = PageRequest.of(1, 10);
//        labelRepository.findAll(pageRequest);
//        Label label = labelService.findByName(name);
        List<TreeNode> labelsRequest = new ArrayList<>();

        TreeNode treeNode = TreeNode.builder()
                .name(name)
                .build();
        labelsRequest.add(treeNode);

        List<TreeNode> labelsByName = labelService.findLabelsByName(labelsRequest);

        return Flux.fromIterable(labelsByName);
    }

}
