package spk.aws.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello World Tag", description = "First test controller of the project.")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        return "Hello World!!!";
    }
}
