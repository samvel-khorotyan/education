package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String phone;
    private Lesson[] lesson;
}
