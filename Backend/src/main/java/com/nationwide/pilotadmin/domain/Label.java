package com.nationwide.pilotadmin.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rushidesai
 */
@Data
@Builder
@Entity
@EqualsAndHashCode(of = {"id", "name"})
public class Label {

    @Column
    @Id
    @GeneratedValue
    private long id;

    @Column
    @NonNull
    private int level;

    @Column
    @NonNull
    private String name;


    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "Pilot_Label",
//            joinColumns = {@JoinColumn(name = "label_id")},
//            inverseJoinColumns = {@JoinColumn(name = "pilot_id")}
//    )
    private Set<Node> nodes;

//    @JsonBackReference
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "Label_Label_Associations",
//            joinColumns = {@JoinColumn(name = "label_1_id")},
//            inverseJoinColumns = {@JoinColumn(name = "label_2_id")}
//    )
//    private Set<Label> labels;

    public Set<Node> getNodes() {
        if (nodes == null) {
            nodes = new HashSet<>();
        }
        return nodes;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", nodes=" + nodes.stream().map(Node::getName).collect(Collectors.joining(", ")) +
//                ", labels=" + labels +
                '}';
    }
}
