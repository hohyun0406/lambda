package user;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString

public class User {
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String jmNumber;
    private String callNumber;
    private String address;
    private String job;

    private double height;
    private double weight;

    public void setPassword(String password) {
        this.password = password;
    }

    @Builder (builderMethodName = "builder")
    public User(String username, String password, String confirmPassword, String name, String jmNumber, String callNumber, String address, String job, double height, double weight) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.jmNumber = jmNumber;
        this.callNumber = callNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }


}
