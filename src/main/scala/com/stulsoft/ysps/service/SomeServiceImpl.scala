package com.stulsoft.ysps.service

class SomeServiceImpl(commonValue: Int) extends SomeService {
  override def add(i1: Int, i2: Int): Int = commonValue + i1 + i2
}
