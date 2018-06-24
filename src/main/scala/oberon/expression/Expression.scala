package oberon.expression

sealed trait Type 

case class BoolType extends Type
case class IntType extends Type
case class UndefinedType extends Type

trait Expression {
  def eval(): Value
  def calculateType(): Type
  def typeCheck(): Boolean = calculateType != UndefinedType()
}

trait Value extends Expression {
  def eval() = this 
}

case class Undefined() extends Value {

  override def calculateType(): Type = UndefinedType

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
case class IntValue(value: Integer) extends Value {

  override def calculateType(): Type = IntType

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
case class BoolValue(value: Boolean) extends Value {

  override def calculateType(): Type = BoolType

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}