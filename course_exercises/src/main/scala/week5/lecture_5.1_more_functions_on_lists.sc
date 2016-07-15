
def removeAt(n: Int, xs: List[String]) = (xs take n) ::: (xs drop n+1)

val list = List("a","b","c","d")

removeAt(1, list)

list take 1
list drop 2