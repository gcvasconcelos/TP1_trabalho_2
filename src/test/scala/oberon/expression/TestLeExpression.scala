package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestLeExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an lower or equal expression"

  it should "return value true when Le(IntValue(1), IntValue(2))" in {
    val val2 = IntValue(2);
    val val1 = IntValue(1);
    val le = new LeExpression(val1, val2)

    le.eval() should be (BoolValue(true)) 
  }

  it should "return value true when Le(IntValue(2), IntValue(2))" in {
    val val2 = IntValue(2);
    val val1 = IntValue(1);
    val sum = new AddExpression(val1, val1)
    val le = new LeExpression(sum, val2)

    le.eval() should be (BoolValue(true)) 
  }

  it should "return value false when Le(IntValue(2), IntValue(1))" in {
    val val2 = IntValue(2);
    val val1 = IntValue(1);
    val le = new LeExpression(val2, val1)

    le.eval() should be (BoolValue(false)) 
  }

}
