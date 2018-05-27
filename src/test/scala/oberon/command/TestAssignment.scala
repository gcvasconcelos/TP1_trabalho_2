package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._

class TestAssignment extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an assignment command"

  before {
    clear()
  }

  it should "change inicial value of variable" in { 
    val x = new VarDeclaration("x")
    x.run
    val newx = new Assignment("x", IntValue(5))
    newx.run

    lookup("x") match {
      case Some(map) => map("x") should be (IntValue(5)) 
      case _         => 1 should be (0)
    }
  }

  it should "throw an error when variable wasn't declared" in { 
    a [VariableNotDeclared] should be thrownBy {
      val x = new Assignment("x", IntValue(5))
      x.run()
    } 
  }
}
