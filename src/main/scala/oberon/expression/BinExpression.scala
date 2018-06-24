package oberon.expression

import oberon.visitor._

abstract class BinExpression(val lhs: Expression, val rhs: Expression) extends Expression {  }

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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType()
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType()
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    lhs.calculateType == rhs.calculateType match {
      case true => lhs.calculateType
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    lhs.calculateType == rhs.calculateType match {
      case true => lhs.calculateType
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == IntType()) match {
      case true => IntType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == BoolType()) match {
      case true => BoolType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    List(lhs, rhs).forall(foo => foo.calculateType == BoolType()) match {
      case true => BoolType()
      case _    => UndefinedType() 
    }
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

  override def calculateType(): Type = {
    value.calculateType == BoolType() match {
      case true => BoolType()
      case _    => UndefinedType() 
    }
    }

}