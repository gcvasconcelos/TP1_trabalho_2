package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


import oberon.Environment._
import oberon.expression._
import oberon.command._

class TestFor extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a for command"

  before {
    clear()
  }

  it should "lookup(soma) must be equal to 10" in {
    val a1 = new Assignment("soma", IntValue(0))   
    val a2 = new Assignment("val1", IntValue(1))      
    val a3 = new Assignment("i", IntValue(0))
    val a4 = new Assignment("i", new AddExpression(new VarRef("i"), new IntValue(1)))
    val a5 = new Assignment("soma", new AddExpression(new VarRef("soma"), new VarRef("val1")))
    val cond = new LoExpression(new VarRef("soma"), new IntValue(10))
    val w1 = new For(a3, cond, a4, a5)

    a1.run()
    a2.run()
    w1.run()

    val res = lookup("soma")
    res match {
      case Some(v) => v.eval() should be (IntValue(10))
      case _       => 0 should be (1)
    }
  }
}
