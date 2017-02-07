// PartialFunction allows us to check if an input argument exist
// in a function
val f: PartialFunction[String, String] = {
  case "ping" => "pong"
}
f("ping")
f.isDefinedAt("abc")
f.isDefinedAt("ping")

// We can see that isDefinedAt works on the outermost pattern
// matching block
val g: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case _ :: rest =>
    rest match {
      case Nil => "two"
    }
}

g.isDefinedAt(List(1, 2, 3))
g(List(1, 2, 3))