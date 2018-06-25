package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon._

class TestDeclaration extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a declaration command"

  before {
    clear()
  }

  it should "declare a variable and initialize it with undefined value" in { 
    val x = new VarDeclaration(IntType(), "x")
    x.run()

    lookup("x") match {
      case Some(_var) => _var should be (Undefined()) 
      case _         => 1 should be (0)
    }
  }

  it should "throw an error when two declarations of the same variable" in { 
    a [VariableAlreadyDeclared] should be thrownBy {
      val x = new VarDeclaration(IntType(), "x")
      x.run()
      val otherx = new VarDeclaration(IntType(), "x")
      x.run()
    } 
  }

}
