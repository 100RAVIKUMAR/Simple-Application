package com.Geekster.UserManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    private String user_id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$")
    private String username;
    @NotBlank
    private String dob;
    @NotBlank
    @Email(message = "please enter an valid email adress!!!")
    private String email;
    @NotEmpty
    @Size(min = 12 , max = 12)
    private String ph_no;
    @Pattern(regexp = "^(?:(?:(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec))(\\/|-|\\.)31)\\1|(?:(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))(\\/|-|\\.)(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:(?:0?2|(?:Feb))(\\/|-|\\.)(?:29)\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))(\\/|-|\\.)(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})+$")
    private String Date;
    private LocalTime time;
}
