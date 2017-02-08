package week1.src

class rand {

  trait Generator[+T] {
    self =>

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      override def generate: S = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      override def generate: S = f(self.generate).generate
    }
  }

  val integers = new Generator[Int] {
    val rand = new java.util.Random

    override def generate: Int = rand.nextInt()
  }

  val booleans: Generator[Boolean] = for (x <- integers) yield x >= 0

  val pairs: Generator[(Int, Int)] = for (x <- integers; y <- integers) yield (x, y)

  def single(x: Int) = new Generator[Int] {
    override def generate: Int = x
  }

  def choose(lo: Int, hi: Int): Generator[Int] = for (x <- integers) yield lo + x % (hi - lo)

  def oneOf[T](xs: T*): Generator[T] = for (x <- choose(0, xs.length)) yield xs(x)
}
