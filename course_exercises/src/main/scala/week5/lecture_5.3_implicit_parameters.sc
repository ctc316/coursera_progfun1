import math.Ordering

//def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length/2
  if(n==0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
//        if (lt(x, y)) x :: merge(xs1, ys)
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt(n)
//    merge(msort(fst)(lt), msort(snd)(lt))
//    merge(msort(fst)(ord), msort(snd)(ord))
    merge(msort(fst), msort(snd))
  }
}

val nums = List(2, -4, 5, 7, 1)
//msort(nums)((x, y) => x < y)
msort(nums)(Ordering.Int)

val fruits = List("apple", "pineapple", "orange", "banana")
//msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
msort(fruits)(Ordering.String)