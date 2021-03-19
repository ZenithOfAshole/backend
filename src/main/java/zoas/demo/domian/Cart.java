package zoas.demo.domian;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.One;

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

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL) // cart를 persist 해도 cartItem에 persist
    private List<CartItem> cartItems = new ArrayList<>();


    @Column(name = "cart_quantity")
    private int quantity; //장바구니 내 주문수량


    //연관 관게 메서드
    public void setUser(User user){
        this.user = user;
        user.setCart(this);
    }
    public void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }


    // 카트 생성 메소드
    public static Cart createCart(User user,CartItem... cartItems){
        Cart cart = new Cart();
        cart.setUser(user);

        for(CartItem cartItem : cartItems){
            cart.addCartItem(cartItem);
        }

        return cart;
    }



}
