package ffs.service.trainer;

import ffs.domain.Trainer;
import ffs.dto.response.trainer.SearchTrainerResponse;
import ffs.repository.trainer.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchTrainerService {

    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainer() {
        return trainerRepository.findAll();
    }

    public SearchTrainerResponse getTrainerByName(String name, String lastPhoneNumber) {
        List<Trainer> trainerList = trainerRepository.findOneByName(name);

        if(trainerList.isEmpty()) {
            log.info("Can not found trainer. name={}, lastPhoneNumber={}", name, lastPhoneNumber);
            return null;
        }

        Trainer trainer = getTrainerOfSameLastPhoneNumber(trainerList, lastPhoneNumber);

        if(trainer == null) {
            log.info("Can not found trainer. name={}, lastPhoneNumber={}", name, lastPhoneNumber);
            return null;
        }

        return getTrainerResponse(trainer);
    }

    private Trainer getTrainerOfSameLastPhoneNumber(List<Trainer> trainerList, String lastPhoneNumber) {
        for (Trainer trainer : trainerList) {
            if(trainer.getPhoneNumber().endsWith(lastPhoneNumber)) {
                return trainer;
            }
        }

        return null;
    }

    private SearchTrainerResponse getTrainerResponse(Trainer trainer) {
        return SearchTrainerResponse.builder()
                .name(trainer.getName())
                .phoneNumber(trainer.getPhoneNumber())
                .startDate(trainer.getStartDate())
                .workingHour(trainer.getWorkingHour())
                .memberList(trainer.getMemberList())
                .build();
    }
}
