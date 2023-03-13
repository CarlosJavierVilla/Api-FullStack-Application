package com.FullStackApplication.Api.Repositories;

import com.FullStackApplication.Api.Models.Sneaker;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SneakerInMemoryRepository implements ISneakerRepository {

    List<Sneaker> sneakerDB = new ArrayList<>(
            List.of(
                    new Sneaker("Adidas","Forum Low", 110.00d, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/b7beee7c32d4438aaba3acb6001c2e7b_9366/Zapatilla_Forum_Low_Blanco_FY7757_01_standard.jpg"),
                    new Sneaker("Adidas","OZWEEGO", 130.00d, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fdd2ed4315b74f6ea506acb600b20504_9366/Zapatilla_OZWEEGO_Beige_FX6029_01_standard.jpg"),
                    new Sneaker("Adidas","Busenitz", 90.00d, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/87e278ebf8cf4706a3bda7fa00e450a5_9366/Zapatilla_Busenitz_Pro_Negro_G48060_01_standard.jpg"),
                    new Sneaker("Nike","Air Jordan 1 Elevate Low SE", 150.00d, "https://static.nike.com/a/images/t_PDP_1728_v1/39a3b844-cad2-4bf8-9176-7ce09b3e1f0f/air-jordan-1-elevate-low-se-zapatillas-6VS1X9.png"),
                    new Sneaker("Adidas","Air Jordan 1 Mid", 130.00d, "https://static.nike.com/a/images/t_PDP_1728_v1/9609043c-e2ac-4f16-a1fa-952c26212845/air-jordan-1-mid-zapatillas-00qK2m.png"),
                    new Sneaker("Vans","Sk8-Hi", 90.00d, "https://images.vans.com/is/image/VansEU/VN000D5IB8C-HERO?wid=1800&hei=1800"),
                    new Sneaker("Vans","Chukka Low sidestripe", 75.00d, "https://images.vans.com/is/image/VansEU/VN0A5KQZ77F-HERO?wid=1800&hei=1800"),
                    new Sneaker("Puma","RX 737 New Vintage", 69.99d, "https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/387573/01/sv01/fnd/EEA/fmt/png/Zapatillas-RX-737-New-Vintage"),
                    new Sneaker("Under Armour","UA HOVR Machina 3 Storm", 170.00d,  "https://underarmour.scene7.com/is/image/Underarmour/3025799-003_DEFAULT?rp=standard-30pad|pdpZoomDesktop&scl=0.50&fmt=jpg&qlt=85&resMode=sharp2&cache=on,on&bgc=f0f0f0&wid=1836&hei=1950&size=850,850"),
                    new Sneaker("Dolce & Gabbana","Wave corte medio en punto elástico", 795.00d, "https://www.dolcegabbana.com/dw/image/v2/AAGA_PRD/on/demandware.static/-/Sites-15/default/dw0f771657/images/zoom/CK2116AE396_8B969_0.jpg"),
                    new Sneaker("test","Wave corte medio en punto elástico", 795.00d, "https://www.dolcegabbana.com/dw/image/v2/AAGA_PRD/on/demandware.static/-/Sites-15/default/dw0f771657/images/zoom/CK2116AE396_8B969_0.jpg")
            )
    );

    @Override
    public List<Sneaker> findAll(){
        return this.sneakerDB;
    }
    @Override
    public Sneaker findById(UUID id){
        return this.sneakerDB.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
    }
    @Override
    public Sneaker createSneaker(Sneaker sneaker){
        this.sneakerDB.add(sneaker);
        return sneaker;
    }
    @Override
    public Sneaker deleteSneaker(UUID id){
        var sneakerToDelete = this.sneakerDB.stream()
                .filter(item->item.getId().equals(id))
                .findFirst().get();
        this.sneakerDB.remove(sneakerToDelete);
        return sneakerToDelete;
    }
    @Override
    public Sneaker updateSneaker(UUID id, Sneaker sneaker){
        for (Sneaker item: this.sneakerDB){
            if (item.getId().equals(id)){
                item.setBrand(sneaker.getBrand());
                item.setModel(sneaker.getModel());
                item.setPrice(sneaker.getPrice());
                item.setImg(sneaker.getImg());;

                return item;
            }
        }
        return null;
    }


    // Arreglar
    @Override
    public List<Sneaker> searchBy(@RequestParam(required = false) String brand){
        if(brand == null) return this.sneakerDB;
        var filteredSneakers = this.sneakerDB.stream()
                .filter(item-> item.getBrand().contains(brand.toLowerCase()))
                .collect(Collectors.toList());
        return filteredSneakers;
    }
}
