package zoas.demo.domian;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Like {


    @Id @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @OneToOne(mappedBy = "like",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "like", cascade = CascadeType.ALL)
    private List<Item> items= new ArrayList<>();


}
