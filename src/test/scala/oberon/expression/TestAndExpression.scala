package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestAndExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an and expression"

  it should "return true in And(true, true)" in {
    val valtrue  = BoolValue(true)
    val gr = new GrExpression(IntValue(2), IntValue(1))
    val and   = new AndExpression(valtrue, gr) 

    and.eval() should be (BoolValue(true)) 
  }

  it should "return false in And(true, false)" in {
    val valfalse  = BoolValue(false)
    val gr = new GrExpression(IntValue(2), IntValue(1))
    val and   = new AndExpression(valfalse, gr) 

    and.eval() should be (BoolValue(false)) 
  }

  it should "return false in And(false, true)" in {
    val valfalse  = BoolValue(false)
    val gr = new GrExpression(IntValue(2), IntValue(1))
    val and   = new AndExpression(gr, valfalse) 

    and.eval() should be (BoolValue(false)) 
  }

  it should "return false in And(false, false)" in {
    val valfalse  = BoolValue(false)
    val gr = new GrExpression(IntValue(1), IntValue(1))
    val and   = new AndExpression(valfalse, gr) 

    and.eval() should be (BoolValue(false)) 
  }

}
