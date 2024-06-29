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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Avatar> characters;

    @ManyToMany
    @JoinTable(
            name = "company_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies;

    @ManyToMany
    @JoinTable(
            name = "stage_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "stage_id")
    )
    private Set<Stage> stages;
}
