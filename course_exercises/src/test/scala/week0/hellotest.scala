package week0

import org.scalatest.FunSuite

/**
  * Created by ctc316 on 2016/5/15.
  */
class helloTest extends FunSuite{
  test("sayHello method works correctly"){
    val h = new hello
    assert(h.sayHello("Scala") == "Hello, Scala!")
  }
}
