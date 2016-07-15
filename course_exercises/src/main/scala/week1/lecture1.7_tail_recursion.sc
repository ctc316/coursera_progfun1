
def gcd(a: Int, b:Int): Int =
  if(b == 0) a else gcd(b, a%b)

gcd(18,45)


def factorial(n: Int): Int =
  if(n == 0) 1 else n * factorial(n-1)

factorial(5)


//tail recursion
def factorial_tail(n: Int): Int = {
  def loop (acc: Int, n: Int): Int = {
    if(n==0) acc
    else loop(acc * n, n - 1)
  }
  loop(1, n)
}

factorial_tail(5)