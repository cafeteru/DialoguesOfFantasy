package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Data
@Entity
@Table(name = "stages")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private boolean active;

    @OneToMany(mappedBy = "stage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Translation> translations = new HashSet<>();

    @ManyToMany(mappedBy = "stages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    public Stage() {
        this.active = true;
    }
}
