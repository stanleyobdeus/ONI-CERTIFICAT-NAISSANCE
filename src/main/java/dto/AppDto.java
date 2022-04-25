package dto;


import lombok.Data;
import oni.gouv.ht.Models.Request;

@Data
public class AppDto {
    private String name;
    private double price;
    private String ins;

    private Long reqTotal;
    public AppDto(String name, double price, String ins,Long reqTotal){
        this.name = name;
        this.price = price;
        this.ins = ins;
        this.reqTotal=reqTotal;

    }

    public AppDto(double price, Request reuest) {
        this.name = reuest.getApp();
        this.price = price;
        this.ins = reuest.getInstitution();

    }
    public AppDto(double price, String app) {
        this.name = app;
        this.price = price;

    }
}
