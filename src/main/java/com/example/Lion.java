package com.example;

import java.util.List;

public class Lion {
  Feline feline;
  String sex;
  boolean hasMane;

  public Lion(String sex, Feline feline) {
    this.sex = sex;
    this.feline = feline;
  }

  public Lion(String sex) throws Exception {
    if ("Самец".equals(sex)) {
      hasMane = true;
    } else if ("Самка".equals(sex)) {
      hasMane = false;
    } else {
      throw new Exception("Используйте допустимые значения пола животного - самей или самка");
    }
  }

  public int getKittens() {
    return feline.getKittens();
  }

  public boolean doesHaveMane() {
    return hasMane;
  }

  public List<String> getFood() throws Exception {
    return feline.getFood("Хищник");
  }
}
