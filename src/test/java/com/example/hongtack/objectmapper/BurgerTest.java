package com.example.hongtack.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    @Test
    public void 자바를_json으로() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> ingredients = Arrays.asList("고기","야채");
        Burger burger = new Burger("롯데리아",10000,ingredients);

        String json = objectMapper.writeValueAsString(burger);

        String expected = "{\"name\":\"롯데리아\",\"price\":10000,\"ingredients\":[\"고기\",\"야채\"]}";

        assertEquals(json,expected);
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    public void json을_자바객체로() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "{\"name\":\"롯데리아\",\"price\":10000,\"ingredients\":[\"고기\",\"야채\"]}";

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name","롯데리아");
        objectNode.put("price",10000);

        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add("고기");
        arrayNode.add("야채");
        objectNode.set("ingredients",arrayNode);


        String json = objectNode.toString();

        Burger burger = objectMapper.readValue(json,Burger.class);

        List<String> ingredients = Arrays.asList("고기","야채");
        Burger expected = new Burger("롯데리아",10000,ingredients);

        assertEquals(expected.toString(),burger.toString());

        System.out.println(json);
        System.out.println(burger.toString());


    }
}