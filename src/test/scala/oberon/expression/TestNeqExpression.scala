package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestNeqExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a not equal expression"

  it should "return value true when Neq(IntValue(2), IntValue(1))" in {
    val val1 = IntValue(1);
    val val2 = IntValue(2);
    val neq = new NeqExpression(val2, val1)

    neq.eval() should be (BoolValue(true)) 
  }

  it should "return value false when Neq(IntValue(2), IntValue(2))" in {
    val val1 = IntValue(1);
    val val2 = IntValue(2);
    val sum = new AddExpression(val1, val1)
    val neq = new NeqExpression(val2, sum)

    neq.eval() should be (BoolValue(false)) 
  }
}
