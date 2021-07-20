package pl.sdacademy.java.spring.advanced.testexample;

import org.springframework.stereotype.Component;

@Component
public class FooService {
    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public String getValue(int i) {
        return fooRepository.getValue(i) + "xyz";
    }
}
