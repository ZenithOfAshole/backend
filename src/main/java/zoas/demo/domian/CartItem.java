package zoas.demo.domian;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItem {

    @Id @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    private int cartPrice;

    private int count;

    //생성 메서드
    public static CartItem createCartItem(Item item, int cartPrice, int count){
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setCartPrice(cartPrice);
        cartItem.setCount(count);

        item.removeStock(count);
        return cartItem;
    }


    //비지니스 로직
    public int getTotalPrice(){
        return getCartPrice() * getCount();
    }




}
