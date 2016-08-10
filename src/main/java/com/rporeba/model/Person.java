package com.rporeba.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by rporeba on 04.08.2016.
 */

@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 954747632469726049L;

    @Id
    @Column(name = "idP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private Set<Task> taskSet;

}
