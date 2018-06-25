package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.expression._
import oberon.command._
import oberon._

class TestFunction extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a function"

  it should "return 2 when sum(1,1)" in {
    val r1 = new AddExpression(new VarReference("x"), new VarReference("y"))
    val d1 = new FunctionDeclaration(IntType(),"sum", List((IntType(), "x"), (IntType(), "y")), new Return(r1))    
    val f1 = new Function("sum", List(IntValue(1), IntValue(1)))

    f1.eval() should be (IntValue(2))
  }

  it should "return the correct value with multiple commands in function declaration" in {
    val ret1 = new AddExpression(new VarReference("x"), new VarReference("y"))
    val ass1 = new Assignment("x", new AddExpression(new VarReference("x"), IntValue(1)))
    val ass2 = new Assignment("y", new SubExpression(new VarReference("y"), new VarReference("x")))
    val fd = new FunctionDeclaration(IntType(),"summult", List((IntType(), "x"), (IntType(), "y")), new BlockCommand(List(ass1, ass2, new Return(ret1))))
    
    val func1 = new Function("summult", List(IntValue(2), IntValue(4)))

    func1.eval() should be (IntValue(4))
  }

  it should "return the correct value with a while command in function declaration" in {
    val ret1 = new AddExpression(new VarReference("x"), new VarReference("soma"))
    val a3 = new Assignment("soma", new AddExpression(new VarReference("soma"), new VarReference("x")) )
    val a4 = new Assignment("x", new AddExpression(new VarReference("x"), IntValue(1)) )
    val cond = new LeExpression(new VarReference("x"), IntValue(5))
    val w1 = new While(cond, new BlockCommand(List(a3, a4)) )
    val fd = new FunctionDeclaration(IntType(),"while", List((IntType(), "x"), (IntType(), "soma")), new BlockCommand(List(w1, Return(ret1))) )
    
    val func1 = new Function("while", List(IntValue(1), IntValue(0)))

    func1.eval() should be (IntValue(21))
  }
}
