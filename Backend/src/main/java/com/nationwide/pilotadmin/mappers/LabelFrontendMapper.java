package com.nationwide.pilotadmin.mappers;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.LabelMetadata;
import com.nationwide.pilotadmin.dto.frontend.LabelFrontend;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by desair4 on 10/26/2018.
 */
public class LabelFrontendMapper {

    private LabelFrontendMapper() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static List<LabelFrontend> mapLabelsToLabelFrontends(Set<Label> labels) {
        if (labels == null) return Collections.emptyList();

        return labels.stream()
                .map(LabelFrontendMapper::mapLabelToLabelFrontend)
                .collect(Collectors.toList());
    }

    public static LabelFrontend mapLabelToLabelFrontend(Label label) {
        if (label == null) return null;

        LabelMetadata labelMetadata = label.getLabelMetadata();

        return LabelFrontend.builder()
                .description(labelMetadata == null ? "" : labelMetadata.getDescription())
                .name(label.getName())
                .level(label.getLevel())
                .id(label.getId())
                .build();
    }
}
