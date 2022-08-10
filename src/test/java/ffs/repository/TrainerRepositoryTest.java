package ffs.repository;

import ffs.domain.Trainer;
import ffs.repository.impl.TrainerRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class TrainerRepositoryTest {

    @Autowired
    private TrainerRepository trainerRepository;

    @Test
    public void insertTrainerTest() {
        Trainer trainer = getTrainer("trainer");
        Long id = trainerRepository.save(trainer);

        Assertions.assertEquals(trainer, trainerRepository.getOne(id));
    }

    @Test
    public void getAllTrainerTest() {
        Trainer trainer1 = getTrainer("trainer1");
        Trainer trainer2 = getTrainer("trainer2");

        trainerRepository.save(trainer1);
        trainerRepository.save(trainer2);

        Assertions.assertEquals(2, trainerRepository.getAll().size());
    }

    @Test
    public void getTrainerByNameTest() {
        Trainer trainer1 = getTrainer("trainer1");
        trainerRepository.save(trainer1);

        Assertions.assertEquals(trainer1, trainerRepository.findOneByName(trainer1.getName()).get(0));
    }

    private Trainer getTrainer(String name) {
        Trainer trainer = new Trainer();
        trainer.setName(name);
        trainer.setPhoneNumber("1234-1234");
        trainer.setStartDate(LocalDate.now());
        trainer.setWorkingHour(8);

        return trainer;
    }
}