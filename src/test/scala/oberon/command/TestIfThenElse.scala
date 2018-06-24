package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon._

class TestIfThenElse extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an if then else command"

  before {
    clear()
  }

  it should "lookup(result) must be equal to 5" in {
    val d1 = new VarDeclaration("soma")
    d1.run
    val a1 = new Assignment("soma", IntValue(0))   
    a1.run
    
    val d2 = new VarDeclaration("val5")
    d2.run
    val a2 = new Assignment("val5", IntValue(5))   
    a2.run

    val d3 = new VarDeclaration("val10")
    d3.run
    val a3 = new Assignment("val10", IntValue(10))      
    a3.run

    val d4 = new VarDeclaration("result")
    d4.run
    val a4 = new Assignment("result", new AddExpression(new VarReference("val5"), new VarReference("val10")))
    val a5 = new Assignment("result", new SubExpression(new VarReference("val10"), new VarReference("val5")))
    val cond = new GrExpression(new VarReference("val5"), new VarReference("val10"))
    val c1 = new IfThenElse(cond, a4, a5)
    c1.run

    lookup("result") match {
      case Some(_var) => _var should be (IntValue(5))
      case _       => 0 should be (1)
    }
  }

}
