package com.nationwide.pilotadmin.repository;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;

/**
 * @author rushidesai
 */
public interface PilotRepository extends PagingAndSortingRepository<Node, Long> {

    Node findByName(String pilotName);

    List<Node> findAllByLabelsIn(Set<Label> labels);

}
