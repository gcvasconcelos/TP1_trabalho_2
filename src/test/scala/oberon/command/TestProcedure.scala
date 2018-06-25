package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon._

class TestProcedure extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a procedure command and declaration"
  
  before {
    clear
  }

  it should "result 2 when procedure: sum(1,1) is called" in {  
    val c1 = new VarDeclaration(IntType(), "res")
    c1.run
    val c2 = new Assignment("res", new AddExpression(new VarReference("x"), new VarReference("y")))
    val p1 = new ProcedureDeclaration("sum", List((IntType(),"x"),(IntType(),"y")), c2)

    val proc = new Procedure("sum", List(IntValue(1), IntValue(1)))
    proc.run

    lookup("res") match {
      case Some(_var) => _var should be (IntValue(2))
      case _          => 1 should be (0)
    }     
  }

}