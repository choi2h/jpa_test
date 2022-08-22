package ffs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class NewMemberInfo {
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;

    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;

    private boolean isPersonalTraining;
}
