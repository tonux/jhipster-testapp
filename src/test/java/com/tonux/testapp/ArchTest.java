package com.tonux.testapp;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.tonux.testapp");

        noClasses()
            .that()
            .resideInAnyPackage("com.tonux.testapp.service..")
            .or()
            .resideInAnyPackage("com.tonux.testapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.tonux.testapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
