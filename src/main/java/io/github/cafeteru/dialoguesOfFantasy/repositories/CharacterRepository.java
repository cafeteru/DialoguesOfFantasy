package io.github.cafeteru.dialoguesOfFantasy.repositories;

import io.github.cafeteru.dialoguesOfFantasy.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
