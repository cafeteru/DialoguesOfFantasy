package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "base_strings")
public class BaseString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String identifier;

    @OneToOne(cascade = CascadeType.ALL)
    private Character characterName;

    @OneToOne(cascade = CascadeType.ALL)
    private Character characterSurname;

    @OneToOne(cascade = CascadeType.ALL)
    private Character characterDescription;

    @OneToMany(mappedBy = "baseString", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Translation> translations = new HashSet<>();

    public void addTranslation(Translation... translations) {
        this.translations.addAll(List.of(translations));
        Arrays.stream(translations).forEach(translation -> translation.setBaseString(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseString that = (BaseString) o;
        return Objects.equals(id, that.id) && Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identifier);
    }
}
