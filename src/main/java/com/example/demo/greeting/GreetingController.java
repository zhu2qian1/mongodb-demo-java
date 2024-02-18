package com.example.demo.greeting;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ApplicationPaths;


@RestController
public class GreetingController {
    private static final String TEMPLATE(final String name) {
        return String.format("Hello, %s!", name);
    }

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(ApplicationPaths.Greeting.path)
    public Greeting greet(@RequestParam(value = "name", defaultValue = "world") final String name) {
        return new Greeting(counter.incrementAndGet(), TEMPLATE(name));
    }

}
