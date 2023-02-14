package springmvc.coffeeStore2.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//▼▼▼▼▼▼CoffeeController2 의 작동을 위해 주석처리▼▼▼▼▼▼
//RestController -> 1.빈등록 2.엔드포인트로 동작함
//@RestController
//@RequestMapping(value=("v1/coffees"), produces = {MediaType.APPLICATION_JSON_VALUE})
//@RequestMapping("/v1/coffees")
public class CoffeeController {

    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("engName")String engName,
                                     @RequestParam("korName")String korName,
                                     @RequestParam("price")String price) {
        System.out.println("# engName: " + engName);
        System.out.println("# korName: " + korName);
        System.out.println("# price: " + price);

        Map<String, String> map=new HashMap<>();
        map.put("engName", engName);
        map.put("korName", korName);
        map.put("price", price);


      /*  String response =
                "{\"" +
                        "engName\":\""+engName+"\"," +
                        "\"korName\":\""+korName+"\",\"" +
                        "price\":\"" + price+
                        "\"}";
        //return new ResponseEntity<>(map, HttpStatus.CREATED);*/
        return new ResponseEntity<>(map,HttpStatus.CREATED);
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
