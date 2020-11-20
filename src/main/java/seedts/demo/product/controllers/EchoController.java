package seedts.demo.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EchoController {

    @GetMapping
    public String success() {
        return "Success, it's working!";
    }

}
