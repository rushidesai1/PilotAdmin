package com.nationwide.pilotadmin.dao;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author rushidesai
 */
@Component
@Transactional
public class PilotDao {

    @Autowired
    PilotRepository pilotRepository;

    @Transactional(readOnly = true)
    public List<Node> findAllByLabelsIn(List<Label> labels) {
        if (labels == null) return Collections.emptyList();
        return pilotRepository.findAllByLabelsIn(labels);  //db query
    }

    @Transactional(readOnly = true)
    public List<Node> findAllByLabel(Label label) {
        if (label == null) return Collections.emptyList();

//        return pilotRepository.findAllByNameEquals(label.getName());  //db query
        return pilotRepository.findAllByLabels(label);  //db query
    }

    @Transactional(readOnly = true)
    public Iterable<Node> findAll() {
        return pilotRepository.findAll();  //db query

    }

    @Transactional
    public Node save(Node node) {
        return pilotRepository.save(node);  //db query
    }


}
