package zoas.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zoas.demo.domian.Item;
import zoas.demo.service.ItemService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    //item 상세 정보 가져오기
    @GetMapping(value = "/view/detail/{item_id}")
    public String viewItemDetail(@PathVariable Integer item_id, Model model){
        //삳품정보
        model.addAttribute("item");
        return "item/detail";
    }


    // Category 별 상품목록
    @RequestMapping(value = "/view/list/{category_id}")
    public String viewItemList(@PathVariable("category_id") Long category_id, Model model){
        //data
        List<Item> itemList = itemService.findItemsByCategoryId(category_id);
        model.addAttribute("itemList",itemList);


        //view  모델 명 경로랑 네임 수정 필요
        model.addAttribute("template","fragments/content/item/list");
        return "index";
    }

}
