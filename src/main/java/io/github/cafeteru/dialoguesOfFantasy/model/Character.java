package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "characterName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BaseString name;

    @OneToOne(mappedBy = "characterSurname", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BaseString surname;

    @OneToOne(mappedBy = "characterDescription", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BaseString description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;

    public void setName(BaseString name) {
        this.name = name;
        name.setCharacterName(this);
    }

    public void setSurname(BaseString surname) {
        this.surname = surname;
        surname.setCharacterSurname(this);
    }

    public void setDescription(BaseString description) {
        this.description = description;
        description.setCharacterDescription(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
