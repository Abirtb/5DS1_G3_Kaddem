/*package tn.esprit.spring;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.IUniversiteService;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversiteServiceImpTest {

    private IUniversiteService universiteService;


    private UniversiteRepository universiteRepository;


    private DepartementRepository departementRepository;

    @Test
    @Order(1)
    public void testRetrieveAllUniversites() {
        List<Universite> universites = universiteService.retrieveAllUniversites();
        assertNotNull(universites);
        assertEquals(0, universites.size());
    }

    @Test
    @Order(2)
    public void testAddUniversite() {
        Universite universite = new Universite();
        universite.setNom("Test Universite");
        Universite savedUniversite = universiteService.addUniversite(universite);
        assertNotNull(savedUniversite.getId());
    }

    @Test
    @Order(3)
    public void testUpdateUniversite() {
        Universite universite = universiteService.retrieveAllUniversites().get(0);
        universite.setNom("Updated Universite");
        Universite updatedUniversite = universiteService.updateUniversite(universite);
        assertEquals(universite.getId(), updatedUniversite.getId());
    }

    @Test
    @Order(4)
    public void testRetrieveUniversite() {
        Universite universite = universiteService.retrieveAllUniversites().get(0);
        Universite retrievedUniversite = universiteService.retrieveUniversite(universite.getId());
        assertNotNull(retrievedUniversite);
        assertEquals(universite.getId(), retrievedUniversite.getId());
    }

    @Test
    @Order(5)
    public void testDeleteUniversite() {
        List<Universite> universites = universiteService.retrieveAllUniversites();
        if (!universites.isEmpty()) {
            Universite universite = universites.get(0);
            universiteService.deleteUniversite(universite.getId());
            List<Universite> updatedUniversites = universiteService.retrieveAllUniversites();
            assertTrue(updatedUniversites.size() < universites.size());
        }
    }

    @Test
    @Order(6)
    public void testAssignUniversiteToDepartement() {
        Universite universite = universiteService.retrieveAllUniversites().get(0);
        Departement departement = new Departement();
        departement.setNomDepart("Test Departement");
        Departement savedDepartement = departementRepository.save(departement);
        universiteService.assignUniversiteToDepartement(universite.getId(), savedDepartement.getIdDepart());
        Universite updatedUniversite = universiteService.retrieveUniversite(universite.getId());
        assertTrue(updatedUniversite.getDepartements().contains(savedDepartement));
    }

    @Test
    @Order(7)
    public void testRetrieveDepartementsByUniversite() {
        Universite universite = universiteService.retrieveAllUniversites().get(0);
        List<Departement> departements = universiteService.retrieveDepartementsByUniversite(universite.getId());
        assertNotNull(departements);
    }
}
*/
