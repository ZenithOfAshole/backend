package zoas.demo.domian;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
public class Address {
    @Column(name ="user_zipcode")
    private String zipcode; //우편번호

    @Column(name = "user_address")
    private String address; // 주소

    @Column(name = "user_detail_address")
    private String detail; //상세주소

    protected Address(){

    }

    public Address(String zipcode, String address, String detail) {
        this.zipcode = zipcode;
        this.address = address;
        this.detail = detail;
    }
}
