package com.nationwide.pilotadmin.service;

import com.nationwide.pilotadmin.dto.frontend.LabelFrontend;
import com.nationwide.pilotadmin.dto.tree.TreeNode;
import com.nationwide.pilotadmin.repository.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rushidesai
 */
@Service
public class LabelService {
    LabelRepository labelRepository;

//    boolean attachLabels(Label label1, Label label2) {
//        boolean add = label1.getLabels().add(label2);
//        labelRepository.save(label1);
//        return true;
//    }

    List<TreeNode> findLabelsByName(List<LabelFrontend> labels) {


        return null;
    }

}
