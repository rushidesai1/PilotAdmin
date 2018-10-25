package com.nationwide.pilotadmin.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rushidesai
 */
@Data
@Builder
@EqualsAndHashCode(of = {"id", "name"})
@Entity
public class Node {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private State state;

    @JsonManagedReference
    @ManyToMany(mappedBy = "nodes", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Pilot_Label",
            joinColumns = {@JoinColumn(name = "pilot_id")},
            inverseJoinColumns = {@JoinColumn(name = "label_id")}
    )
    private Set<Label> labels;


//    @JsonBackReference
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "Node_Child_Association",
//            joinColumns = {@JoinColumn(name = "node_1_id")},
//            inverseJoinColumns = {@JoinColumn(name = "node_2_id")}
//    )
//    private Set<Node> nodes;


    public Set<Label> getLabels() {
        if (labels == null) {
            labels = new HashSet<>();
        }
        return labels;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", labels=" + labels.stream().map(Label::getName).collect(Collectors.joining(", ")) +
                '}';
    }
}
