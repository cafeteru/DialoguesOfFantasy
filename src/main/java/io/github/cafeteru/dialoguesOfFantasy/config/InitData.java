package io.github.cafeteru.dialoguesOfFantasy.config;

import io.github.cafeteru.dialoguesOfFantasy.model.Character;
import io.github.cafeteru.dialoguesOfFantasy.model.*;
import io.github.cafeteru.dialoguesOfFantasy.repositories.CharacterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@Slf4j
public class InitData {
    @Bean
    protected CommandLineRunner initDatabase(
            CharacterRepository characterRepository) {
        return args -> {
            var company = new Company();
            company.setName("Square Enix");
            var project = new Project();
            project.setName("Final Fantasy VII Ever Crisis");
            project.setCompanies(Set.of(company));
            var stage = new Stage();
            stage.setName("Production");
            project.setStages(Set.of(stage));
            var languageEng = new Language();
            languageEng.setIsoCode("en");
            languageEng.setName("English");
            var languageEsp = new Language();
            languageEsp.setIsoCode("es");
            languageEsp.setName("Spanish");
            var translationEng = new Translation();
            translationEng.setContent("Aerith");
            translationEng.setLanguage(languageEng);
            translationEng.setStage(stage);
            var translationEsp = new Translation();
            translationEsp.setContent("Aeris");
            translationEsp.setLanguage(languageEsp);
            translationEsp.setStage(stage);
            var name = new BaseString();
            name.addTranslation(translationEng, translationEsp);
            var aerith = new Character();
            aerith.setName(name);
            aerith.setProject(project);
            characterRepository.save(aerith);
        };
    }
}
