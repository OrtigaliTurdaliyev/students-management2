package uz.pdp.studentsmanagement.students;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private int course;

}
