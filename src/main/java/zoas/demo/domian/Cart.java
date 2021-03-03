package zoas.demo.domian;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter @Setter
public class Cart {


    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(mappedBy = "cart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items= new ArrayList<>();

    @Column(name = "cart_quantity")
    private int quantity; //장바구니 내 주문수량
}
