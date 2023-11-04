package tn.esprit.spring.kaddem.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@Slf4j
class DepartementServiceImplTest {

    DepartementServiceImpl underTest;

    @Mock
    DepartementRepository departementRepository;

    @BeforeAll
    static void beforeAll() {
        log.info("[START] Running DepartmentServiceImpl unit tests.");
    }

    @BeforeEach
    void setUp() {
        underTest = new DepartementServiceImpl(departementRepository);
    }

    @AfterAll
    static void afterAll() {
        log.info("[END] Running DepartmentServiceImpl unit tests.");
    }

    @Test
    void shouldReturnNotNullResponseWhenRetrieveAllDepartments() {
        log.info("Starting shouldReturnNotNullResponseWhenRetrieveAllDepartments() test.");

        // GIVEN
        log.debug("Creating GIVEN step for the test : empty departmentList.");
        List<Departement> departementList = new ArrayList<>();

        // WHEN
        log.debug("Mocking department repository when using findAll().");
        Mockito.when(departementRepository.findAll()).thenReturn(departementList);

        // THEN
        log.debug("Asserting retrieveAllDepartements() response is notNull.");
        Assertions.assertEquals(0, underTest.retrieveAllDepartements().size());

        log.info("Ending shouldReturnNotNullResponseWhenRetrieveAllDepartments() test.");
    }

    @Test
    void shouldReturnValidDepartmentWhenAdd(){
        log.info("Starting shouldReturnValidDepartmentWhenAdd() test.");

        // GIVEN
        log.debug("Creating GIVEN step for the test : department.");
        Departement departement = new Departement(1,"DS1");

        // WHEN
        log.debug("Mocking department repository when using save().");
        Mockito.when(departementRepository.save(Mockito.any())).thenReturn(departement);

        // THEN
        log.debug("Asserting addDepartement() response is equal to given department.");
        Assertions.assertNotNull(underTest.addDepartement(departement));

        log.info("Ending shouldReturnValidDepartmentWhenAdd() test.");
    }

    @Test
    void shouldReturnDepartmentWhenRetrieve(){
        log.info("Starting shouldReturnDepartmentWhenRetrieve() test.");

        // GIVEN
        log.debug("Creating GIVEN step for the test : department.");
        Departement departement = new Departement(2,"DS2");

        // WHEN
        log.debug("Mocking department repository when using findById().");
        Mockito.when(departementRepository.findById(Mockito.any())).thenReturn(Optional.of(departement));

        // THEN
        log.debug("Asserting retrieveDepartement() response is equal to given department.");
        Assertions.assertNotNull(underTest.retrieveDepartement(2));

        log.info("Ending shouldReturnDepartmentWhenRetrieve() test.");
    }

    @Test
    void shouldReturnUpdatedDepartmentWhenUpdate(){
        log.info("Starting shouldReturnUpdatedDepartmentWhenUpdate() test.");

        // GIVEN
        log.debug("Creating GIVEN step for the test : departement and departementUpdated.");
        Departement departement = new Departement(3,"DS3");
        Departement departementUpdated = new Departement(3,"DS4");

        // WHEN
        log.debug("Mocking department repository when using save().");
        Mockito.when(departementRepository.save(Mockito.any())).thenReturn(departementUpdated);

        // THEN
        log.debug("Asserting updateDepartement() response is equal to given department.");
        departement.setNomDepart(("DS4"));
        Assertions.assertEquals("DS4", underTest.updateDepartement(departement).getNomDepart());

        log.info("Ending shouldReturnUpdatedDepartmentWhenUpdate() test.");
    }
}