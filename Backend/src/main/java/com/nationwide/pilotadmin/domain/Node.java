package com.nationwide.pilotadmin.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author rushidesai
 */
@Data
@Builder
//@EqualsAndHashCode(of = {"id", "name"})
@Entity
public class Node {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private State state;

    //    @JsonManagedReference
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "nodes")
    /*@JoinTable(
            name = "Pilot_Label",
            joinColumns = {@JoinColumn(name = "pilot_id")},
            inverseJoinColumns = {@JoinColumn(name = "label_id")}
    )*/
    @EqualsAndHashCode.Exclude
    private Set<Label> labels;

//    @JsonManagedReference
//    @ManyToMany(mappedBy = "nodes", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "Pilot_Label",
//            joinColumns = {@JoinColumn(name = "pilot_id")},
//            inverseJoinColumns = {@JoinColumn(name = "label_id")}
//    )
//    @EqualsAndHashCode.Exclude
//    private Set<Node> nodeChildren;
//    @EqualsAndHashCode.Exclude
//    private Set<Node> nodeParent;

//    @JsonBackReference
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "Node_Child_Association",
//            joinColumns = {@JoinColumn(name = "node_1_id")},
//            inverseJoinColumns = {@JoinColumn(name = "node_2_id")}
//    )
//    private Set<Node> nodes;


//    public Set<Label> getLabels() {
//        if (labels == null) {
//            labels = new HashSet<>();
//        }
//        return labels;
//    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", level='" + level + '\'' +
                ", state=" + state +
//                ", labels=" + labels.stream().map(Label::getName).collect(Collectors.joining(", ")) +
                '}';
    }
}
