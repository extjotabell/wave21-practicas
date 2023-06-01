package com.example.generico;

public enum Color {
  RED(255, 0, 0),
  GREEN(0, 255, 0),
  BLUE(0, 0, 255),
  YELLOW(255, 255, 0),
  BROWN(165, 42, 42),
  BLACK(0, 0, 0),
  WHITE(255, 255, 255);

  private final int r;
  private final int g;
  private final int b;
  Color(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;

  }

}
