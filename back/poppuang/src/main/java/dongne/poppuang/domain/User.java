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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "major_id")
    private Major major;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private Long clicks;

    @Column(nullable = false)
    private Timestamp created_at;
}
