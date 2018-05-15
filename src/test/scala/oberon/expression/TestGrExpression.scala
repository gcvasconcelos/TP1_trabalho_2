package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestGrExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an greater expression"

  it should "return value true when Gr(IntValue(2), IntValue(1))" in {
    val val1 = IntValue(1);
    val val2 = IntValue(2);
    val gr = new GrExpression(val2, val1)

    gr.eval() should be (BoolValue(true)) 
  }

  it should "return value false when Gr(IntValue(2), IntValue(2))" in {
    val val1 = IntValue(1);
    val val2 = IntValue(2);
    val sum = new AddExpression(val1, val1)
    val gr = new GrExpression(val2, sum)

    gr.eval() should be (BoolValue(false)) 
  }

  it should "return value false when Gr(IntValue(1), IntValue(2))" in {
    val val1 = IntValue(1);
    val val2 = IntValue(2);
    val gr = new GrExpression(val1, val2)

    gr.eval() should be (BoolValue(false)) 
  }

}
