package io.github.cafeteru.dialoguesOfFantasy.repositories;

import io.github.cafeteru.dialoguesOfFantasy.model.Character;
import io.github.cafeteru.dialoguesOfFantasy.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
