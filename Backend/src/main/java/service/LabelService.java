package service;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.repository.LabelRepository;
import org.springframework.stereotype.Service;

/**
 * @author rushidesai
 */
@Service
public class LabelService {
    LabelRepository labelRepository;

    boolean attachLabels(Label label1, Label label2) {
        boolean add = label1.getLabels().add(label2);
        labelRepository.save(label1);
        return true;
    }

}
