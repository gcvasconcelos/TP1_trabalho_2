package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestLoExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an lower expression"

  it should "return value true when Ge(IntValue(1), IntValue(2))" in {
    val val1 = IntValue(1)
    val val2 = IntValue(2)
    val lo = new LoExpression(val1, val2)

    lo.eval() should be (BoolValue(true)) 
  }

  it should "return value false when Ge(IntValue(2), IntValue(2))" in {
    val val1 = IntValue(1)
    val val2 = IntValue(2)
    val sum = new AddExpression(val1, val1)
    val lo = new LoExpression(sum, val2)

    lo.eval() should be (BoolValue(false)) 
  }
  
  it should "return value false when Ge(IntValue(2), IntValue(1))" in {
    val val1 = IntValue(1)
    val val2 = IntValue(2)
    val lo = new LoExpression(val2, val1)

    lo.eval() should be (BoolValue(false)) 
  }

}
