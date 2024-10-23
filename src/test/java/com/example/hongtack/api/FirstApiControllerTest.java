package com.example.hongtack.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FirstApiControllerTest {

    @Test
    @DisplayName("hello test")
    void hello() {
        FirstApiController helloController = new FirstApiController();
        String text = helloController.hello();

        String expect = "hell";

        assertEquals(text,expect);
    }
}