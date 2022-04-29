package dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Request;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationDto {

    private Long id;
    private String name;
    private double price;
    private String ins;
    private Long reqTotal;
    private String origin;
    private String secret_key;
    private String public_key;
    private int strict;

    public ApplicationDto(String name, double price, String ins, Long reqTotal){
        this.name = name;
        this.price = price;
        this.ins = ins;
        this.reqTotal=reqTotal;

    }

    public ApplicationDto(Long id,String name,String ins,double request_price,String origin,String public_key,String secret_key,int strict){
     this.id=id;
     this.name=name;
     this.ins=ins;
     this.price=request_price;
     this.origin=origin;
     this.public_key=public_key;
     this.secret_key=secret_key;
     this.strict=strict;
    }

    public ApplicationDto(Application a){
        this.id=a.getId();
        this.name=a.getName();
        this.ins=a.getIns().getName();
        this.price=a.getRequest_price();
        this.origin=a.getOrigin();
        this.public_key=a.getPublic_key();
        this.secret_key=a.getSecret_key();
        this.strict=a.getStrict();
    }


    public ApplicationDto(double price, Request reuest) {
        this.name = reuest.getApp();
        this.price = price;
        this.ins = reuest.getInstitution();

    }
    public ApplicationDto(double price, String app) {
        this.name = app;
        this.price = price;

    }
}
