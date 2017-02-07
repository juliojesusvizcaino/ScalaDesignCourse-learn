// PartialFunction allows us to check if an input argument exist
// in a function
val f: PartialFunction[String, String] = {
  case "ping" => "pong"
}
f("ping")
f.isDefinedAt("abc")
f.isDefinedAt("ping")