package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "characterName", fetch = FetchType.LAZY)
    private BaseString name;

    @OneToOne(mappedBy = "characterSurname", fetch = FetchType.LAZY)
    private BaseString surname;

    @OneToOne(mappedBy = "characterDescription", fetch = FetchType.LAZY)
    private BaseString description;

    @ManyToOne
    private Project project;
}
