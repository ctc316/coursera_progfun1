package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def factorial(n: Int): Int = {
        def loop (acc: Int, n: Int): Int = {
          if(n==0) acc
          else loop(acc * n, n - 1)
        }
        loop(1, n)
      }

      if (c == 0 || c == r) 1
//      else pascal(c - 1, r - 1) + pascal(c, r - 1)
      else factorial(r)/factorial(c)/factorial(r-c)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      var stack = 0
      if(chars.isEmpty) true
      else {
        for(c <- chars){
          c match{
            case '(' => stack+=1
            case ')' => if(stack<=0) stack= -10000 else stack-=1
            case _ =>
          }
        }
        stack==0
      }
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
