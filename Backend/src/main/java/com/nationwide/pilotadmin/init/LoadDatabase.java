package com.nationwide.pilotadmin.init;

import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.domain.State;
import com.nationwide.pilotadmin.repository.LabelRepository;
import com.nationwide.pilotadmin.repository.PilotRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author rushidesai
 */
@Log
@Configuration
public class LoadDatabase {

    @Autowired
    PilotRepository pilotRepository;
    @Autowired
    LabelRepository labelRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("Preloading ");
//            log.info("Preloading " +));

            Node node1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();
            Node node2 = Node.builder().name("CARD_2").state(State.builder().isPilotOn(true).build()).build();
//        Node node1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();

            Label label1 = Label.builder().name("CARD_1").level(1).build();
            Label label2 = Label.builder().name("FEAT_1").level(2).build();
            Label label3 = Label.builder().name("PROJ_1").level(3).build();

            Label label4 = Label.builder().name("CARD_2").level(1).build();
            Label label5 = Label.builder().name("FEAT_2").level(2).build();
            Label label6 = Label.builder().name("PROJ_2").level(3).build();

            List<Node> nodes = new ArrayList<>();
//            List<Label> labels = new ArrayList<>();
//            labels.add(label1);

            label1.getNodes().add(node1);
            node1.getLabels().add(label1);
            node1.getLabels().add(label2);
            node1.getLabels().add(label3);
            nodes.add(node1);

            label1.getNodes().add(node1);   //attach node and label
            node1.getLabels().add(label1);
            node1.getLabels().add(label2);
            node1.getLabels().add(label3);
            nodes.add(node1);
//        nodes.add(node2);
//        nodes.add(pilot3);

            pilotRepository.save(node1);

            Iterable<Node> all = pilotRepository.findAll();
            String stringToLog = StreamSupport.stream(all.spliterator(), false)
                    .map(Node::toString)
                    .collect(Collectors.joining("\n"));
            log.info(stringToLog);

        };
    }
}