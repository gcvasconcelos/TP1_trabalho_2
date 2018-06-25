package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestNotExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an not expression"

  it should "return true in Not(false)" in {
    val valfalse  = BoolValue(false)
    val not   = new NotExpression(valfalse) 

    not.eval() should be (BoolValue(true)) 
  }

  it should "return false in Not(true)" in {
    val valtrue  = BoolValue(true)
    val not   = new NotExpression(valtrue) 

    not.eval() should be (BoolValue(false)) 
  }

}
