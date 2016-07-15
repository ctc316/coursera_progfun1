object exercise1 {
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  //
  //def id(x: Int): Int = x
  //def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)

  //def sumInts(a: Int, b: Int) = sum(id, a, b)
  //def sumCubes(a: Int, b: Int) = sum(cube, a, b)
  def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

  //Anonymous Function Syntax
  def sumInts(a: Int, b: Int) = sum(x => x, a, b)
  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

  sumInts(1, 4)
  1 + 2 + 3 + 4

  sumCubes(1, 4)
  1 + 8 + 27 + 64

  sumFactorials(1, 4)
  1 + 1 * 2 + 1 * 2 * 3 + 1 * 2 * 3 * 4
}

object exercise2{
  //tail-recursive
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a>b) acc
      else loop(a + 1,f(a) + acc)
    }
    loop(a,0)
  }
  sum(x => x * x, 3, 5)
}

