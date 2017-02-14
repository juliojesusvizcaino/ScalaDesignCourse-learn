def from(n: Int): Stream[Int] = n #:: from(n + 1)

val nats = from(0)
val m4s = nats map (_ * 4)

(m4s take 100).toList