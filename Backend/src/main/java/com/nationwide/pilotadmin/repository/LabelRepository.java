package com.nationwide.pilotadmin.repository;

import com.nationwide.pilotadmin.domain.Label;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author rushidesai
 */
public interface LabelRepository extends PagingAndSortingRepository<Label, Long> {
    Label findByName(String name);

    List<Label> findAllByNameEquals(String name);

    List<Label> findAllByNameIn(List<String> names);

    Label findByNameEquals(String name);
}
