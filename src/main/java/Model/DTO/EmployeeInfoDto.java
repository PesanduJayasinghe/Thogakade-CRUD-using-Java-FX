package Model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeInfoDto {

    private String employeeId;
    private String name;
    private String nit;
    private String dob;
    private String position;
    private double salary;
    private String contactNumber;
    private String address;
    private String joinedDate;
    private String status;

}
