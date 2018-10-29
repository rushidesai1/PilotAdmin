package com.nationwide.pilotadmin.repository;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author rushidesai
 */
public interface PilotRepository extends PagingAndSortingRepository<Node, Long> {

    Node findByName(String pilotName);

    List<Node> findAllByLabelsIn(List<Label> labels);

    List<Node> findAllByNameEquals(String labelName);

    List<Node> findAllByLabels(Label label);

}
