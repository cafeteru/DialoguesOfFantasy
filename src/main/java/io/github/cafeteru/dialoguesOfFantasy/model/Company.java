package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private boolean active;

    @ManyToMany(mappedBy = "companies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    public Company() {
        this.active = true;
    }
}
