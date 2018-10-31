package com.nationwide.pilotadmin.init;

import com.nationwide.pilotadmin.dao.LabelDao;
import com.nationwide.pilotadmin.dao.PilotDao;
import com.nationwide.pilotadmin.domain.Label;
import com.nationwide.pilotadmin.domain.Node;
import com.nationwide.pilotadmin.domain.State;
import com.nationwide.pilotadmin.repository.LabelRepository;
import com.nationwide.pilotadmin.repository.PilotRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
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
    PilotDao pilotDao;

    @Autowired
    LabelDao labelDao;

    @Autowired
    PilotRepository pilotRepository;

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    EntityManager entityManager;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("Preloading ");

            Node node1 = Node.builder().name("CARD_1").state(State.builder().isPilotOn(true).build()).build();
            Node node2 = Node.builder().name("CARD_2").state(State.builder().isPilotOn(true).build()).build();
            Node node3 = Node.builder().name("CARD_3").state(State.builder().isPilotOn(true).build()).build();

            pilotDao.save(node1);
            pilotDao.save(node2);
            pilotDao.save(node3);

            Label label1 = Label.builder().name("CARD_1").level(0).build();
            Label label2 = Label.builder().name("FEAT_1").level(2).build();
            Label label3 = Label.builder().name("PROJ_1").level(3).build();

            Label label4 = Label.builder().name("CARD_2").level(0).build();
            Label label5 = Label.builder().name("FEAT_2").level(2).build();
            Label label6 = Label.builder().name("PROJ_2").level(3).build();

            Label label7 = Label.builder().name("PROJ_4").level(4).build();

            Label label8 = Label.builder().name("CARD_3").level(0).build();


            label1.getNodes().add(node1);
            label2.getNodes().add(node1);
            label3.getNodes().add(node1);
            label7.getNodes().add(node1);

            label4.getNodes().add(node2);
            label5.getNodes().add(node2);
            label6.getNodes().add(node2);

            label2.getNodes().add(node3);
            label5.getNodes().add(node3);
            label7.getNodes().add(node3);
            label8.getNodes().add(node3);

            List<Label> labels = new ArrayList<>();
            labels.add(label1);
            labels.add(label2);
            labels.add(label3);
            labels.add(label4);
            labels.add(label5);
            labels.add(label6);
            labels.add(label7);
            labels.add(label8);
            labelDao.saveAll(labels);
//
//            setup(node1, label1, label2, label3, label7);
//            pilotDao.save(node1);


//            label7 = labelRepository.findByNameEquals("PROJ_4");
//            setup(node2, label4, label5, label6, label7);
//            setup(node2, label4, label5, label6);
//            pilotDao.save(node2);


//            label2 = labelRepository.findByName("FEAT_1");
//            label5 = labelRepository.findByName("FEAT_2");
//            setup(node3, label8, label2, label5, label7);
//            pilotDao.save(node3);

//            nodes.add(node1);
//            nodes.add(node2);
//            nodes.add(node3);


            Iterable<Node> all = pilotDao.findAll();
            String stringToLog = StreamSupport.stream(all.spliterator(), false)
                    .map(Node::toString)
                    .collect(Collectors.joining("\n"));
            log.info(stringToLog);

        };
    }

//    private void setup(Node node, Label... labels) {
//        if (labels == null) return;
//        Arrays.stream(labels)
//                .forEach(node.getLabels()::add);
//    }
}