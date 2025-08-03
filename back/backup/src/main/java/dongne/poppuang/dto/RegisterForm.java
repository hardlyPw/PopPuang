package dongne.poppuang.dto;


import jakarta.validation.constraints.*;

public class RegisterForm {
    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "유효한 이메일 형식이어야 합니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상입니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력하세요.")
    private String confirmPassword;

    @NotBlank(message = "학부 정보를 입력하세요.")
    private String department;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
// getters & setters
}
