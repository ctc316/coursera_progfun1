
val n = 7
//(1 until n) flatMap (i => (1 until i)) map (j => (i, j)))// filter (pair => isPrime(pair._1 + pair._2)
//
//for {
//  i <- 1 until n
//  j <- 1 until i
//  if isPrime(i + j)
//} yield  (i, j)


def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
  (for ((x, y) <- xs zip ys) yield x*y).sum
}

val xs = List[Double](1, 2, 1)
val ys = List[Double](2, 2, 3)
scalarProduct(xs, ys)