package pl.sda.ro76.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/car")
@Profile("!dev") //with -Dspring.profiles.active=dev in VM options
public class CarController {

    @Value("${car.default.model}")
    private String carDefaultModel;


    @GetMapping({"/{brand}/{model}","/{brand}/"})
    @ResponseBody
    public String getCarModel(@PathVariable(name = "brand") final String brand,
                              @PathVariable(name = "model", required = false) final String model) {
        return "For brand " + brand + " the default model is: " + (model == null ? carDefaultModel : model);
    }
}
