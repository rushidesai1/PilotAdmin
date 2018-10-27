package com.nationwide.pilotadmin.repository;

import com.nationwide.pilotadmin.domain.Label;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author rushidesai
 */
public interface LabelRepository extends PagingAndSortingRepository<Label, Long> {
    Label findByName(String name);
}
