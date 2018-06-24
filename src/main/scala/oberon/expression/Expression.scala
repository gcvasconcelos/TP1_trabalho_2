package oberon.expression

import oberon.visitor._

trait Expression extends Visitable {
  def eval(): Value 
}

trait Value extends Expression {
  def eval() = this 
}

case class Undefined() extends Value {

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
case class IntValue(value: Integer) extends Value {

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
case class BoolValue(value: Boolean) extends Value {

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}