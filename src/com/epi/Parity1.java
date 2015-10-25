package com.epi;

public class Parity1 {
  // @include
  public static short parity(long x) {
    short result = 0;
    while (x != 0) {
      result ^= (x & 1);
      //System.out.println(Long.toBinaryString(x));
      x >>= 1;
      //System.out.println(Long.toBinaryString(x));
    }
    return result;
  }
  // @exclude
}
