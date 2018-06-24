package oberon.expression

import oberon.visitor._

abstract class BinExpression(val lhs: Expression, val rhs: Expression) extends Expression {

}

class AddExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value + v2.value)
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class SubExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value - v2.value)
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class MultExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value * v2.value)
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class DivExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value / v2.value)
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class ModExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value % v2.value)
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class EqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval()
    val v2 = rhs.eval()

    return BoolValue(v1 == v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class LeExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 <= v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class GeExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 >= v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class LoExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 < v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class GrExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 > v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class NeqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 != v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class AndExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[BoolValue].value
    val v2 = rhs.eval().asInstanceOf[BoolValue].value

    return BoolValue(v1 && v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class OrExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[BoolValue].value
    val v2 = rhs.eval().asInstanceOf[BoolValue].value

    return BoolValue(v1 | v2) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

class NotExpression(value: Expression) extends Expression {

  override
  def eval: Value = {
    val v1 = value.eval().asInstanceOf[BoolValue].value

    return BoolValue(!v1) 
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}