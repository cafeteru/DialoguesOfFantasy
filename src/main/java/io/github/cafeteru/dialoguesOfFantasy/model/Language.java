package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String isoCode;
    private boolean active;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Translation> translations = new HashSet<>();

    public Language() {
        this.active = true;
    }
}
