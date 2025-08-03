package dongne.poppuang.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String username;
    private String department;
    private String password;
    private String passwordConfirm;

}
