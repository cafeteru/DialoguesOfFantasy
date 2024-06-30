package io.github.cafeteru.dialoguesOfFantasy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String content;
    private boolean active;

    @ManyToOne(cascade = CascadeType.ALL)
    private BaseString baseString;

    @ManyToOne(cascade = CascadeType.ALL)
    private Language language;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stage stage;

    public Translation() {
        this.active = true;
    }
}
