package ffs.repository.trainer;

import ffs.domain.Trainer;

import java.util.List;

public interface TrainerRepository {

    Long save(Trainer trainer);

    Trainer findOne(Long id);

    List<Trainer> findAll();

    List<Trainer> findOneByName(String name);
}
