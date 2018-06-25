package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestDivExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a division expression"

  it should "return value 2 in Divide(IntValue(10), IntValue(5))" in {
    val val10 = IntValue(10)
    val val5  = IntValue(5)
    val diff   = new DivExpression(val10, val5) 

    diff.eval() should be (IntValue(2)) 
  }

  it should "lead to an exception in Divide(IntValue(5), BoolValue(False))" in {
  }
  
}
