package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon._

class TestWhile extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a while command"

  before {
    clear()
  }
  // soma := 0;
  //    x := 1;
  // while(x <= 10) begin
  //   soma := soma + x;
  //      x := x + 1;
  // end
  // print(soma);  
  it should "lookup(soma) must be equal to 55 after a loop summing up 1 to 10" in {
    val d1 = new VarDeclaration("soma")
    d1.run
    val a1 = new Assignment("soma", IntValue(0))   
    a1.run    

    val d2 = new VarDeclaration("x")
    d2.run
    val a2 = new Assignment("x", IntValue(1))   
    a2.run

    val a3 = new Assignment("soma",new AddExpression(new VarReference("soma"), new VarReference("x")))
    val a4 = new Assignment("x", new AddExpression(new VarReference("x"), IntValue(1)))
    val cond = new LeExpression(new VarReference("x"), IntValue(10))
    val c1 = new While(cond, new BlockCommand(List(a3, a4)))
    c1.run

    val res = lookup("soma")
    res match {
      case Some(_var) => _var should be (IntValue(55))
      case _       => 5 should be (1)
    }
  }
}
