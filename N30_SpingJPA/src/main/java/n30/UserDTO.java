package n30;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String birthday;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday());
    }

    public User toEntity(){
        try {
            return new User(id, login, firstName, lastName, new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
