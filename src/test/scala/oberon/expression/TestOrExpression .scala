package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestOrExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an or expression"

  it should "return true in Or(true, true)" in {
    val valtrue  = BoolValue(true)
    val gr = new GrExpression(IntValue(2), IntValue(1))
    val or   = new OrExpression(valtrue, gr) 

    or.eval() should be (BoolValue(true)) 
  }

  it should "return true in Or(true, false)" in {
    val valfalse  = BoolValue(false)
    val gr = new GrExpression(IntValue(2), IntValue(1))
    val or   = new OrExpression(valfalse, gr) 

    or.eval() should be (BoolValue(true)) 
  }

  it should "return true in Or(false, true)" in {
    val valfalse  = BoolValue(false)
    val gr = new GrExpression(IntValue(2), IntValue(1))
    val or   = new OrExpression(gr, valfalse) 

    or.eval() should be (BoolValue(true)) 
  }

  it should "return false in Or(false, false)" in {
    val valfalse  = BoolValue(false)
    val gr = new GrExpression(IntValue(1), IntValue(1))
    val or   = new OrExpression(valfalse, gr) 

    or.eval() should be (BoolValue(false)) 
  }

}
