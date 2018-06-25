package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestEqExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an equality expression"

  it should "return value true in Eq(IntValue(1), IntValue(1))" in {
    val val2 = IntValue(2)  
    val sum2  = new AddExpression(IntValue(1), IntValue(1))  
    val eq   = new EqExpression(val2, sum2)

    eq.eval() should be (BoolValue(true)) 
  }

  it should "return value false in Eq(IntValue(5), IntValue(3))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val eq   = new EqExpression(val5, val3)

    eq.eval() should be (BoolValue(false)) 
  }

}
