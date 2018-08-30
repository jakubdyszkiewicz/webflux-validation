package org.jakubd.validation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/validate")
public class ValidationEndpoint {

    @PostMapping
    public Mono<Void> validated(@RequestBody @Valid Mono<TestBody> body) {
        return body.then();
    }

    public static class TestBody {

        @NotNull
        private Integer x;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }
    }
}
