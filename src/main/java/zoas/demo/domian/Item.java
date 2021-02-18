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

    private String name;

    private int price;

    private String img; //제품 이미지

    private int stockQuantity;

    @Column(name = "itme_detail")
    private String detail;      // 제품 설명

    @ManyToMany(mappedBy = "items")    //연관관계 수정 필요
    private List<Category> categories = new ArrayList<>();


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
