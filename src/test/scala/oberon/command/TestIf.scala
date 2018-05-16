package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


import oberon.Environment._
import oberon.expression._
import oberon.command._

class TestIf extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an if command"

  before {
    clear()
  }

  it should "lookup(soma) must be equal to 10" in {
    val a1 = new Assignment("soma", IntValue(0))   
    val a2 = new Assignment("val5", IntValue(5))      
    val a3 = new Assignment("val10", IntValue(10))      
    val a4 = new Assignment("soma", new AddExpression(new VarRef("soma"), new VarRef("val10")))
    val cond = new LoExpression(new VarRef("val5"), new VarRef("val10"))
    val w1 = new If(cond, a4)

    a1.run()
    a2.run()
    a3.run()
    w1.run()

    val res = lookup("soma")
    res match {
      case Some(v) => v.eval() should be (IntValue(10))
      case _       => 0 should be (1)
    }
  }

  it should "lookup(soma) must be equal to 15" in {
    val a1 = new Assignment("soma", IntValue(0))   
    val a2 = new Assignment("val5", IntValue(5))      
    val a3 = new Assignment("val10", IntValue(10))  
    val a4 = new Assignment("res", new AddExpression(new VarRef("val5"), new VarRef("val10")))    
    val a5 = new Assignment("soma", new AddExpression(new VarRef("soma"), new VarRef("res")))
    val cond = new LoExpression(new VarRef("val5"), new VarRef("val10"))
    val w1 = new If(cond, new BlockCommand(List(a4, a5)))

    a1.run()
    a2.run()
    a3.run()
    a4.run()
    w1.run()

    val res = lookup("soma")
    res match {
      case Some(v) => v.eval() should be (IntValue(15))
      case _       => 0 should be (1)
    }
  }
}
