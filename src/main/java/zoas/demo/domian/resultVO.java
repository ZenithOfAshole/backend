package zoas.demo.domian;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class resultVO {

    private int status;
    private String message;
    private Object data;


}
