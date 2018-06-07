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

  behavior of "a procedure"
  
  before {
    clear
  }

  it should "result 2 when procedure: sum(1,1) is called" in {  
    val a1 = new VarDeclaration("res")
    val a2 =  new AddExpression(new VarReference("x"), new VarReference("y"))
    val cmd = new Assignment("res", a2)
    val p1 = new ProcedureDeclaration("sum", List("x","y"), cmd)
    val proc = new Procedure("sum", List(IntValue(1), IntValue(1)))
    a1.run
    proc.run

    lookup("res") match {
        case Some(map) => map("res") should be (IntValue(2))
        case _         => 1 should be (0)
    }     
  }

}