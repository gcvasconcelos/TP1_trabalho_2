package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestMultExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a multiplication expression"

  it should "return value 50 in Multiply(IntValue(10), IntValue(5))" in {
    val val10 = IntValue(10)
    val val5  = IntValue(5)
    val diff   = new MultExpression(val10, val5) 

    diff.eval() should be (IntValue(50)) 
  }

  it should "lead to an exception in Divide(IntValue(5), BoolValue(False))" in {
  }

}
