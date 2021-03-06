package zoas.demo.domian;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_phoneNumber")
    private String phoneNumber;

    @Column(name = "user_register_at")
    @CreatedDate
    private LocalDateTime registerAt;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>(); //

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Cart cart;

}
