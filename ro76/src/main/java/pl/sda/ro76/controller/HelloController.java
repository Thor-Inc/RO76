package pl.sda.ro76.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sda.ro76.model.PersonDTO;

@Controller
@RequestMapping(path = "/first")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable(name = "name") final String name) {
        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @ResponseBody
    public String getWithRequestParam(@RequestParam(name = "lastName") final String lastName,
                                      @RequestParam(name = "firstName") final String firstName) {
        return "Hello " + firstName + " " + lastName ;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/hello")
    @ResponseBody
    public String helloToPerson(@RequestBody PersonDTO personDTO) {
        return "Hello " + personDTO.getFirstName() + " " + personDTO.getLastName() ;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello2")
    public String hello() {
        return "welcome";
    }

    private static final String MODEL_HELLO_MESSAGE_ATTRIBUTE_NAME = "helloMsg";

    @GetMapping("/helloWithText")
    public String showHello(final ModelMap modelMap) {
        modelMap.addAttribute(MODEL_HELLO_MESSAGE_ATTRIBUTE_NAME, "hello in thymeleaf from model map");
        return "welcome";
    }







    @GetMapping("/helloWithView/{name}")
    public String showHello(final ModelMap modelMap, @PathVariable(name = "name") String name) {
        modelMap.addAttribute(MODEL_HELLO_MESSAGE_ATTRIBUTE_NAME, "hello in thymeleaf from model map " + name);
        return "welcome";
    }
}
