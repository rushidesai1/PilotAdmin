package com.nationwide.pilotadmin.repository;

import com.nationwide.pilotadmin.domain.Node;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author rushidesai
 */
public interface PilotRepository extends PagingAndSortingRepository<Node, Long> {

    Node findByName(String pilotName);

}
