package pl.sdacademy.java.spring.hellocontext.example.interfaces;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DocumentHandler {

    private final Set<Output> outputs;

    public DocumentHandler(Set<Output> outputs) {
        this.outputs = outputs;
    }

    public void handleDocument(Document document) {
        outputs.stream()
                .filter(o -> o.supports(document))
                .forEach(o -> o.handle(document));
    }
}
