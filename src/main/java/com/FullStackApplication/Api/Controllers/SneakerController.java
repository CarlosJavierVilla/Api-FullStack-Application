package com.FullStackApplication.Api.Controllers;


import com.FullStackApplication.Api.Models.Sneaker;
import com.FullStackApplication.Api.Repositories.SneakerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/sneakers")
public class SneakerController {

    private final SneakerRepository sneakerRepository = new SneakerRepository();
    List<Sneaker> sneakerDB = new ArrayList<>(
            List.of(
                    new Sneaker("Adidas","Forum Low", 110.0d, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/b7beee7c32d4438aaba3acb6001c2e7b_9366/Zapatilla_Forum_Low_Blanco_FY7757_01_standard.jpg"),
                    new Sneaker("Adidas","OZWEEGO", 130.0d, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fdd2ed4315b74f6ea506acb600b20504_9366/Zapatilla_OZWEEGO_Beige_FX6029_01_standard.jpg"),
                    new Sneaker("Adidas","Busenitz", 90.0d, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/87e278ebf8cf4706a3bda7fa00e450a5_9366/Zapatilla_Busenitz_Pro_Negro_G48060_01_standard.jpg"),
                    new Sneaker("Nike","Air Jordan 1 Elevate Low SE", 150.0d, "https://static.nike.com/a/images/t_PDP_1728_v1/39a3b844-cad2-4bf8-9176-7ce09b3e1f0f/air-jordan-1-elevate-low-se-zapatillas-6VS1X9.png"),
                    new Sneaker("Adidas","Air Jordan 1 Mid", 130.0d, "https://static.nike.com/a/images/t_PDP_1728_v1/9609043c-e2ac-4f16-a1fa-952c26212845/air-jordan-1-mid-zapatillas-00qK2m.png"),
                    new Sneaker("Vans","Sk8-Hi", 90.0d, "https://images.vans.com/is/image/VansEU/VN000D5IB8C-HERO?wid=1800&hei=1800"),
                    new Sneaker("Vans","Chukka Low sidestripe", 75.0d, "https://images.vans.com/is/image/VansEU/VN0A5KQZ77F-HERO?wid=1800&hei=1800"),
                    new Sneaker("Puma","RX 737 New Vintage", 69.99d, "https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/387573/01/sv01/fnd/EEA/fmt/png/Zapatillas-RX-737-New-Vintage"),
                    new Sneaker("Under Armour","UA HOVR Machina 3 Storm", 170.0d,  "https://underarmour.scene7.com/is/image/Underarmour/3025799-003_DEFAULT?rp=standard-30pad|pdpZoomDesktop&scl=0.50&fmt=jpg&qlt=85&resMode=sharp2&cache=on,on&bgc=f0f0f0&wid=1836&hei=1950&size=850,850"),
                    new Sneaker("Dolce & Gabbana","Wave corte medio en punto elástico", 795.0d, "https://www.dolcegabbana.com/dw/image/v2/AAGA_PRD/on/demandware.static/-/Sites-15/default/dw0f771657/images/zoom/CK2116AE396_8B969_0.jpg"),
                    new Sneaker("test","Wave corte medio en punto elástico", 795.0d, "https://www.dolcegabbana.com/dw/image/v2/AAGA_PRD/on/demandware.static/-/Sites-15/default/dw0f771657/images/zoom/CK2116AE396_8B969_0.jpg")
            )
    );
    @GetMapping
    public List<Sneaker> getAll() {
        return this.sneakerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sneaker getById(@PathVariable UUID id) {
        return this.sneakerRepository.findById(id);
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getById(@PathVariable UUID id) {

         var sneakerOptional = this.sneakerDB.stream()
              .filter(item -> item.getId().equals(id))
              .findFirst();

        if(sneakerOptional.isEmpty()) return  ResponseEntity.notFound().build();
        return new ResponseEntity<>(sneakerOptional.get(), HttpStatus.OK);

    }*/


    @PostMapping
    public Sneaker create(@RequestBody Sneaker sneaker) {
        return sneakerRepository.createSneaker(sneaker);
    }


    @DeleteMapping("{id}")
    public Sneaker deleteById(@PathVariable UUID id){
        return sneakerRepository.deleteSneaker(id);
    }
    @PutMapping("{id}")
    public Sneaker updateById(@PathVariable UUID id, @RequestBody Sneaker sneaker){
        return sneakerRepository.updateSneaker(id, sneaker);
    }

    @GetMapping("search")
    public List<Sneaker> searchBy(@RequestParam(required = false) String brand){
        if(brand == null) return this.sneakerDB;
        var filteredSneakers = this.sneakerDB.stream()
                .filter(item-> item.getBrand().contains(brand.toLowerCase()))
                .collect(Collectors.toList());
        return filteredSneakers;
    }


}
