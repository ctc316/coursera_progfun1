package funsets


/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  //Meaning:
  //Int => Boolean is the type of a function that takes one argument, an Int, and returns a Boolean.
  //type MyType = Int => Boolean
  //example:
  //val greaterThan5: MyType = (x: Int) => x > 5
  //greaterThan5(7)  // true

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = (elem2: Int) => elem == elem2  //or {elem2: Int => elem == elem2}

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
    def union(s: Set, t: Set): Set =  {elem: Int => contains(s,elem) || contains(t, elem)}

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set = {elem: Int => contains(s,elem) && contains(t, elem)}

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = {elem: Int => contains(s,elem) && !contains(t, elem)}

  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = {elem: Int => contains(s,elem) && contains(p,elem)}


  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
      def loop(a: Int): Boolean = {
        if (a == -bound) true
        else if ((contains(s, a)) && (!contains(filter(s, p), a))) false
        else loop(a - 1)
      }
      loop(bound)
    }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
    def exists(s: Set, p: Int => Boolean): Boolean = {
        !forall(s, (x: Int) => !p(x))

//      def loop(a: Int): Boolean = {
//        if (a == -bound) false
//        else if ((contains(s, a)) && (contains(filter(s, p), a))) true
//        else loop(a - 1)
//      }
//      loop(bound)
    }

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
    def map(s: Set, f: Int => Int): Set = {elem: Int => exists(s, {elem2:Int => f(elem2) == elem}) }


  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
