package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon._

class TestIfThen extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an if then command"

  before {
    clear()
  }

  it should "lookup(soma) must be equal to 10" in {
    val d1 = new VarDeclaration(IntType(), "soma")
    d1.run
    val a1 = new Assignment("soma", IntValue(0))   
    a1.run
    
    val d2 = new VarDeclaration(IntType(), "val5")
    d2.run
    val a2 = new Assignment("val5", IntValue(5))   
    a2.run

    val d3 = new VarDeclaration(IntType(), "val10")
    d3.run
    val a3 = new Assignment("val10", IntValue(10))      
    a3.run

    val a4 = new Assignment("soma", new AddExpression(new VarReference("soma"), new VarReference("val10")))
    val cond = new LoExpression(new VarReference("val5"), new VarReference("val10"))
    val c1 = new IfThen(cond, a4)
    c1.run

    lookup("soma") match {
      case Some(_var) => _var should be (IntValue(10))
      case _       => 0 should be (1)
    }
  }

  it should "lookup(soma) must be equal to 15" in {
    val d1 = new VarDeclaration(IntType(), "soma")
    d1.run
    val a1 = new Assignment("soma", IntValue(0))   
    a1.run

    val d2 = new VarDeclaration(IntType(), "val5")
    d2.run
    val a2 = new Assignment("val5", IntValue(5))   
    a2.run

    val d3 = new VarDeclaration(IntType(), "val10")
    d3.run
    val a3 = new Assignment("val10", IntValue(10))      
    a3.run

    val d4 = new VarDeclaration(IntType(), "res")
    d4.run

    val a4 = new Assignment("res", new AddExpression(new VarReference("val5"), new VarReference("val10")))    
    a4.run

    val a5 = new Assignment("soma", new AddExpression(new VarReference("soma"), new VarReference("res")))
    
    val cond = new LoExpression(new VarReference("val5"), new VarReference("val10"))
    val c1 = new IfThen(cond, new BlockCommand(List(a4, a5)))
    c1.run

    lookup("soma") match {
      case Some(_var) => _var should be (IntValue(15))
      case _       => 0 should be (1)
    }
  }
  
}
