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
public class BaseString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String identifier;

    @OneToOne
    private Character characterName;

    @OneToOne
    private Character characterSurname;

    @OneToOne
    private Character characterDescription;

    @OneToMany(mappedBy = "baseString", fetch = FetchType.LAZY)
    private Set<Translation> translations;
}
