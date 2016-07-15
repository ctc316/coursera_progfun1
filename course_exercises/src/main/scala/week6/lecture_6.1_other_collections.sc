
val xs = Array(1,2,3,44)
xs map (x => x*2)

val str = "Hello World"
str filter (c => c.isUpper)
str exists (c => c.isUpper)
str forall (c => c.isUpper)
str flatMap (c => List('_', c))

val r: Range = 1 until 5
val s: Range = 1 to 20

1 to 10 by 3
6 to 1 by -2

val pairs = List(1, 2, 3) zip str
pairs.unzip

r.sum
s.reverse