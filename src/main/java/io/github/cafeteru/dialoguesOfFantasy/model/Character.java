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
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "characterName", fetch = FetchType.LAZY)
    private Set<BaseString> names;

    @OneToMany(mappedBy = "characterSurname", fetch = FetchType.LAZY)
    private Set<BaseString> surnames;
}
