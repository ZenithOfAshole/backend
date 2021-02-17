package zoas.demo.domian;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name ="category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    /*
    manytomany 수정 필요
     */
    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns =  @JoinColumn(name = "item_id")) //category가 연관관계 주인
    private List<Item> items = new ArrayList<>();

}
