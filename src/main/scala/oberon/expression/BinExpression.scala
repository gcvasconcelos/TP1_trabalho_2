package oberon.expression

abstract class BinExpression(val lhs: Expression, val rhs: Expression) extends Expression {

}

class AddExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value + v2.value)
  }

}

class SubExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value - v2.value)
  }

}

class MultExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value * v2.value)
  }

}

class DivExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value / v2.value)
  }

}

class ModExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval() : Value = {
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(v1.value % v2.value)
  }

}

class EqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval()
    val v2 = rhs.eval()

    return BoolValue(v1 == v2) 
  }

}

class LeExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 <= v2) 
  }

}

class GeExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 >= v2) 
  }

}

class LoExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 < v2) 
  }

}

class GrExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 > v2) 
  }

}

class NeqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[IntValue].value
    val v2 = rhs.eval().asInstanceOf[IntValue].value

    return BoolValue(v1 != v2) 
  }

}

class AndExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[BoolValue].value
    val v2 = rhs.eval().asInstanceOf[BoolValue].value

    return BoolValue(v1 && v2) 
  }

}

class OrExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {

  override
  def eval: Value = {
    val v1 = lhs.eval().asInstanceOf[BoolValue].value
    val v2 = rhs.eval().asInstanceOf[BoolValue].value

    return BoolValue(v1 | v2) 
  }

}

class NotExpression(value: Expression) extends Expression {

  override
  def eval: Value = {
    val v1 = value.eval().asInstanceOf[BoolValue].value

    return BoolValue(!v1) 
  }

}