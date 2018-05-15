package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestGeExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an greater or equal expression"

  it should "return value true when Ge(IntValue(2), IntValue(1))" in {
    val val2 = IntValue(2);
    val val1 = IntValue(1);
    val ge = new GeExpression(val2, val1)

    ge.eval() should be (BoolValue(true)) 
  }
  
  it should "return value true when Ge(IntValue(2), IntValue(2))" in {
    val val2 = IntValue(2);
    val val1 = IntValue(1);
    val sum = new AddExpression(val1, val1)
    val ge = new GeExpression(val2, sum)

    ge.eval() should be (BoolValue(true)) 
  }
  
  it should "return value false when Ge(IntValue(1), IntValue(2))" in {
    val val2 = IntValue(2);
    val val1 = IntValue(1);
    val ge = new GeExpression(val1, val2)

    ge.eval() should be (BoolValue(false)) 
  }

}
