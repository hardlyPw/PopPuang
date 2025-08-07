package dongne.poppuang.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private Timestamp created_at;

    //유저의 클릭 수를 나타내는 변수
    @Column(nullable = false)
    private Long clicks = 0L;
}

