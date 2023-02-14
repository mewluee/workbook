package springmvc.coffeeStore2.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//RestController -> 1.빈등록 2.엔드포인트로 동작함
@RestController
//@RequestMapping(value=("v1/coffees"), produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping("/v1/coffees")
public class CoffeeController2 {


    @PostMapping
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto) {
        System.out.println("# postCoffee");

        return new ResponseEntity<>(coffeePostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                      @RequestBody CoffeePatchDto coffeePatchDto){
        coffeePatchDto.setPrice(6000);
        System.out.println("# patchCoffee");
        return new ResponseEntity<>(coffeePatchDto, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id")long coffeeId){
        System.out.println("# coffeeId : "+coffeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        System.out.println("안녕 난 커피야.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
