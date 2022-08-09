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

    public Long save(Trainer trainer) {
        em.persist(trainer);
        return trainer.getId();
    }

    public Trainer getOne(Long id) {
        return em.find(Trainer.class, id);
    }

    public List<Trainer> getAll() {
        return em.createQuery("Select t from Trainer t", Trainer.class).getResultList();
    }

    public List<Trainer> getOneByName(String name) {
        return em.createQuery("select t from Trainer t where t.name = :name", Trainer.class)
                .setParameter("name", name)
                .getResultList();
    }

}
