package uz.pdp.studentsmanagement.courses.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {

    private int id;

    private String name;

    private String description;


}
