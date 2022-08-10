package ffs.repository.impl;

import ffs.domain.Trainer;
import ffs.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrainerRepositoryImpl implements TrainerRepository {

    private final EntityManager em;

    public Long save(Trainer trainer) {
        em.persist(trainer);
        return trainer.getId();
    }

    public Trainer findOne(Long id) {
        return em.find(Trainer.class, id);
    }

    public List<Trainer> findAll() {
        return em.createQuery("Select t from Trainer t", Trainer.class).getResultList();
    }

    public List<Trainer> findOneByName(String name) {
        return em.createQuery("select t from Trainer t where t.name = :name", Trainer.class)
                .setParameter("name", name)
                .getResultList();
    }

}
