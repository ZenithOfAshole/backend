package zoas.demo.domian;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Component
@Getter
@Setter
@ToString(exclude = "user")
@NoArgsConstructor
@Entity
public class Token implements Serializable{

    private static final long serialVersionId = 1L;


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tokenValue;

    @Id @GeneratedValue
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String tokenType; //구글 , 카카오, 네이버

    @CreatedDate
    private LocalDateTime createdAt;







}
