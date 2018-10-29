package com.nationwide.pilotadmin.dao;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.repository.LabelRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rushidesai
 */
@Component
@Log
public class LabelDao {

    @Autowired
    LabelRepository labelRepository;

    @Transactional
    public void saveAll(List<Label> labels) {
        labelRepository.saveAll(labels);
    }

    @Transactional(readOnly = true)
    public List<Label> findLabelsByName(List<Label> labels) {
//        labelRepository.
        ArrayList<Label> labels1 = new ArrayList<Label>();
        labels1.add(labelRepository.findByName(labels.get(0).getName()));
        return labels1;
//        return null;
    }
}
