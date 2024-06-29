package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "stages")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private boolean active;

    @OneToMany(mappedBy = "stage", fetch = FetchType.LAZY)
    private Set<Translation> translations;

    @ManyToMany(mappedBy = "stages", fetch = FetchType.LAZY)
    private Set<Project> projects;
}
