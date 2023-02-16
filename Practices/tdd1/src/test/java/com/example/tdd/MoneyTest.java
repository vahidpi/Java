package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void testMultiplication() {
    Dollar five=new Dollar(5);
    five.times(2);
    assertEquals(10,five.amount);
  }

  @Test
  void testEquality() {
    assertEquals(new Dollar(5),new Dollar(5));
  }
}
