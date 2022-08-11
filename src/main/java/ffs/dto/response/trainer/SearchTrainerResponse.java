package ffs.dto.response.trainer;

import ffs.domain.Member;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public class SearchTrainerResponse {

    private String name;
    private String phoneNumber;

    private LocalDate startDate;
    private int workingHour;

    private List<Member> memberList;
}
