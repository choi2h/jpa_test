package ffs.repository;

import ffs.domain.Trainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrainerRepository {

    private final EntityManager em;

    private Long save(Trainer trainer) {
        em.persist(trainer);
        return trainer.getId();
    }

    private Trainer getOne(Long id) {
        return em.find(Trainer.class, id);
    }

    private List<Trainer> getAll() {
        return em.createQuery("Select t from Trainer t", Trainer.class).getResultList();
    }

}
