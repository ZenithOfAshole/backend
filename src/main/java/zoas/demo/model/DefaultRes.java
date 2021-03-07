package zoas.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import zoas.demo.util.ResponseMessage;

@Data
@AllArgsConstructor
@Builder
public class DefaultRes<T> {
    private int status;
    private String msg;
    private T data;


    public DefaultRes(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
    }

    public static <T>DefaultRes<T> res(final int status, final  String msg){
        return res(status,msg,null);
    }

    public static<T>DefaultRes<T> res(final int status,final String msg,final T t){
        return DefaultRes.<T>builder()
                .data(t)
                .status(status)
                .msg(msg)
                .build();
    }

    public static final DefaultRes FAIL_DEFAULT_RES
            = new DefaultRes(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR); //현상태, 메시지

}
