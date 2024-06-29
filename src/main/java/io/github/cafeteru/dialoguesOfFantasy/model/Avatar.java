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
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "avatarName", fetch = FetchType.LAZY)
    private BaseString name;

    @OneToOne(mappedBy = "avatarSurname", fetch = FetchType.LAZY)
    private BaseString surname;

    @OneToOne(mappedBy = "avatarDescription", fetch = FetchType.LAZY)
    private BaseString description;

    @ManyToOne
    private Project project;
}
