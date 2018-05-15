package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestSubExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a subtraction expression"

  it should "return value -5 in Subtract(IntValue(5), IntValue(10))" in {
    val val5  = IntValue(5)
    val val10 = IntValue(10)
    val diff   = new SubExpression(val5, val10) 

    diff.eval() should be (IntValue(-5)) 
  }

  it should "lead to an exception in Subtract(IntValue(5), BoolValue(False))" in {
  }
}
