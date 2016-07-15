package funsets

object Main extends App {
  import FunSets._
//  println(contains(singletonSet(1), 1))

  val evenNumSet = union(union(singletonSet(4), singletonSet(6)), singletonSet(-2))
  val oddNumSet = union(union(singletonSet(3), singletonSet(9)), singletonSet(-1))
  val evenAndOddNumbers = union(evenNumSet, oddNumSet)
  println(exists(evenAndOddNumbers, {elem:Int => elem > 0}))
}
