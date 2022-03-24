package n30;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class User {

    @Id
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private Date birthday;

    public UserDTO toDTO(){
        return new UserDTO(id, login, firstName, lastName, new SimpleDateFormat("yyyy-MM-dd").format(birthday));
    }
}
