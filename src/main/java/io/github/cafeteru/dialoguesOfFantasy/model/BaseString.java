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

    @OneToOne
    private Avatar avatarName;

    @OneToOne
    private Avatar avatarSurname;

    @OneToOne
    private Avatar avatarDescription;

    @OneToMany(mappedBy = "baseString", fetch = FetchType.LAZY)
    private Set<Translation> translations;
}
