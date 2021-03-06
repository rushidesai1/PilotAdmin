package service;

import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.repository.PilotRepository;
import dto.frontend.PilotDomain;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rushidesai
 */
@Data
@Service
public class PilotService {
    @Autowired
    private PilotRepository pilotRepository;

    boolean addPilot(PilotDomain pilotDomain) {
//        Node pilot1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();
//        Node pilot2 = Node.builder().name("CARD_2").state(State.builder().isPilotOn(true).build()).build();
////        Node pilot1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();
//
//        Label label1 = Label.builder().name("CARD_1").level(1).build();
//        Label label2 = Label.builder().name("FEAT_1").level(2).build();
//        Label label3 = Label.builder().name("PROJ_1").level(3).build();
//        Label label4 = Label.builder().name("CARD_2").level(1).build();
//        Label label5 = Label.builder().name("FEAT_2").level(2).build();
//        Label label6 = Label.builder().name("PROJ_2").level(3).build();
//
//        List<Node> nodes = new ArrayList<>();
//        List<Label> labels = new ArrayList<>();
//        labels.add(label1);
//
//        nodes.add(pilot1);
////        nodes.add(pilot2);
////        nodes.add(pilot3);
//
//        pilotRepository.saveAll(nodes);

        return true;

    }

    Node fetchPilot(Node node) {
        return pilotRepository.findById(node.getId()).orElse(null);
    }
}
