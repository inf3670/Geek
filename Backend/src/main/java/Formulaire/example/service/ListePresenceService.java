package Formulaire.example.service;

import Formulaire.example.exception.UpdateFailedException;
import Formulaire.example.dto.ListePresenceRequest;
import Formulaire.example.dto.ListePresenceResponse;
import Formulaire.example.entity.ListePresence;
import Formulaire.example.repository.ListePresenceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListePresenceService {
    private final ListePresenceRepository listePresenceRepository;

    public List<ListePresenceResponse> getAllListePresence(){
        return listePresenceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ListePresenceResponse savePresence(ListePresenceRequest listePresenceRequest) {
        return mapToResponse(listePresenceRepository.save(mapToEntity(listePresenceRequest)));
    }

    public ListePresenceResponse updateListePresence(UUID id, ListePresenceRequest listePresenceRequest) {

        ListePresence listePresence = listePresenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListePresence with ID " + id + " not found"));

        try {
            listePresence.setDate(listePresenceRequest.getDate());
            listePresence.setGenre(listePresenceRequest.getGenre());
            listePresence.setNom(listePresenceRequest.getNom());
            listePresence.setPrenom(listePresenceRequest.getPrenom());
            listePresence.setEmail(listePresenceRequest.getEmail());
            listePresence.setTelephone(listePresenceRequest.getTelephone());
            listePresence.setHeureArivee(listePresenceRequest.getHeureArivee());
            listePresence.setHeureDepart(listePresenceRequest.getHeureDepart());
            listePresence.setMotif(listePresenceRequest.getMotif());

            listePresence = listePresenceRepository.save(listePresence);

            return mapToResponse(listePresence);

        } catch (Exception e) {
            throw new UpdateFailedException("Failed to update ListePresence with ID " + id, e);
        }
    }

    public void deletePresence(UUID id) {
        if(!listePresenceRepository.existsById(id)) {
            throw new EntityNotFoundException("ListePresence with id " + id + " not found");
        }
        listePresenceRepository.deleteById(id);
    }

    private ListePresence mapToEntity(ListePresenceRequest listePresenceRequest) {
        ListePresence listeDePresence = ListePresence.builder()
                .date(listePresenceRequest.getDate())
                .genre(listePresenceRequest.getGenre())
                .nom(listePresenceRequest.getNom())
                .prenom(listePresenceRequest.getPrenom())
                .email(listePresenceRequest.getEmail())
                .telephone(listePresenceRequest.getTelephone())
                .heureArivee(listePresenceRequest.getHeureArivee())
                .heureDepart(listePresenceRequest.getHeureDepart())
                .motif(listePresenceRequest.getMotif())
                .build();

        return listeDePresence;
    }

    private ListePresenceResponse mapToResponse(ListePresence listePresence) {
        ListePresenceResponse listePresenceResponse = ListePresenceResponse.builder()
                .id(listePresence.getId())
                .date(listePresence.getDate())
                .genre(listePresence.getGenre())
                .nom(listePresence.getNom())
                .prenom(listePresence.getPrenom())
                .email(listePresence.getEmail())
                .telephone(listePresence.getTelephone())
                .heureArivee(listePresence.getHeureArivee())
                .heureDepart(listePresence.getHeureDepart())
                .motif(listePresence.getMotif())
                .build();

        return listePresenceResponse;
    }
}
