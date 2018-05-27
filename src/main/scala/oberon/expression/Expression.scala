package oberon.expression

trait Expression {
  def eval(): Value 
}

trait Value extends Expression {
  def eval() = this 
}

case class Undefined() extends Value 
case class IntValue(value: Integer) extends Value
case class BoolValue(value: Boolean) extends Value

// trait Function extends Value{
//   def run(): Unit
// }

// case class FunctionExpression(val name: String, val param: String, val command: Command, val _return: Value) extends Function{

//   override 
//   def run(): Value = {
//     stack.map(name, this)
//   }

// }