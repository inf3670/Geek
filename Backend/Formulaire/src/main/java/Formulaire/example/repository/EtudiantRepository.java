package Formulaire.example.repository;

import Formulaire.example.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
