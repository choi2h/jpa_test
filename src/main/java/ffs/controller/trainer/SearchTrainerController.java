package ffs.controller.trainer;

import ffs.domain.Trainer;
import ffs.dto.response.trainer.SearchTrainerResponse;
import ffs.service.trainer.SearchTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchTrainerController {

    private final SearchTrainerService searchTrainerService;

    @GetMapping("/trainers")
    public ResponseEntity<Object> getAllTrainer() {
        List<Trainer> trainers = searchTrainerService.getAllTrainer();
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/trainer")
    public ResponseEntity<Object> getTrainerFromNameAndLastPhoneNumber(@RequestParam String name, @RequestParam String lastPhoneNumber) {
        SearchTrainerResponse response = searchTrainerService.getTrainerByName(name, lastPhoneNumber);

        if(response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(response);
    }
}
