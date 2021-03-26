package zoas.demo.domian;

import lombok.Getter;
import lombok.Setter;
import zoas.demo.exception.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter

public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private int price;

    @Column(name = "item_thumnail")
    private String thumnail;

    @Column(name = "item_img")
    private String img; //제품 이미지

    @Column(name  = "item_stock_quantity")
    private int stockQuantity;

    @Column(name = "item_detail")
    private String detail;      // 제품 설명

    @OneToMany  (mappedBy = "item" ,fetch = FetchType.LAZY)  // 자 : cart에 여러개의 item이 들어갈 수 있지 / 하지만 한 item이 여러 카트에 들어갈 수 잇지
    private List<CartItem> cartItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToOne(mappedBy = "item", fetch = FetchType.LAZY)
    private Like like;


    public void addStock(int quantity){     //제품 수량 증가 메소드 (주문취소시)
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity){      // 제품 수량 제거 (주문 추가)
        int restStock = this.stockQuantity-quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("Need Morde Stock");
        }

        this.stockQuantity = restStock;
    }


}
