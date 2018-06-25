package oberon

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.expression._
import oberon.command._
import oberon.Environment.clear

import oberon.visitor.PrettyPrinter

class TestPrettyPrinter extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "pretty printer"

  before {
    clear()
  }

  it should "print \"(3 + 7)\" when we call accept in addexpression" in {
    val v3 = new VarDeclaration("v3")
    v3.run
    val newv3 = new Assignment("v3", IntValue(3))
    newv3.run

    val v7 = new VarDeclaration("v7")
    v7.run
    val newv7 = new Assignment("v7", IntValue(7))
    newv7.run

    val add   = new AddExpression(v3, v7) 

    val pretty = new PrettyPrinter()

    add.accept(pretty)

    pretty.str should be ("(3 + 7)")
  }

  it should "print \"((3 + 7) + 3)\" when we call accept in addexpression" in {
    val v3 = new VarDeclaration("v3")
    v3.run
    val newv3 = new Assignment("v3", IntValue(3))
    newv3.run

    val v7 = new VarDeclaration("v7")
    v7.run
    val newv7 = new Assignment("v7", IntValue(7))
    newv7.run

    val add   = new AddExpression(v3, v7) 
    val add2  = new AddExpression(add, v3)

    val pretty = new PrettyPrinter()

    add2.accept(pretty)

    pretty.str should be ("((3 + 7) + 3)")
  }

  it should "print \"(3 == 3)\" when we call accept in EqExpression" in {
    val a  = IntValue(3)
    val b = IntValue(3)
    val exp = new EqExpression(a, b)

    val pretty = new PrettyPrinter()

    exp.accept(pretty)

    pretty.str should be ("(3 == 3)")
  }

  it should "print \"(3 == 7)\" when we call accept in NeqExpression" in {
    val v3 = new VarDeclaration("v3")
    v3.run
    val newv3 = new Assignment("v3", IntValue(3))
    newv3.run

    val v7 = new VarDeclaration("v7")
    v7.run
    val newv7 = new Assignment("v7", IntValue(7))
    newv7.run

    val n_eq = new NeqExpression(v3, v7)

    val pretty = new PrettyPrinter()

    n_eq.accept(pretty)

    pretty.str should be ("(3 != 7)")
  }

  it should "print \"(7 > 3)\" when we call accept in GrExpression" in {
    val v3 = new VarDeclaration("v3")
    v3.run
    val newv3 = new Assignment("v3", IntValue(3))
    newv3.run

    val v7 = new VarDeclaration("v7")
    v7.run
    val newv7 = new Assignment("v7", IntValue(7))
    newv7.run

    val gr = new GrExpression(v7, v3)

    val pretty = new PrettyPrinter()

    gr.accept(pretty)

    pretty.str should be ("(7 > 3)")
  }

  it should "print \"(3 >= 3)\" when we call accept in GeExpression" in {
    val a = new VarDeclaration("a")
    a.run
    val newa = new Assignment("a", IntValue(3))
    newa.run

    val b = new VarDeclaration("b")
    b.run
    val newb = new Assignment("b", IntValue(3))
    newb.run

    val geq = new GeExpression(a, b)

    val pretty = new PrettyPrinter()

    geq.accept(pretty)

    pretty.str should be ("(3 >= 3)")
  }

  it should "print \"(3 % 3)\" when we call accept in ModExpression" in {
    val a = new VarDeclaration("a")
    a.run
    val newa = new Assignment("a", IntValue(3))
    newa.run

    val b = new VarDeclaration("b")
    b.run
    val newb = new Assignment("b", IntValue(3))
    newb.run

    val mod = new ModExpression(a, b)

    val pretty = new PrettyPrinter()

    mod.accept(pretty)

    pretty.str should be ("(3 % 3)")
  }

  it should "print \"!true\" when we call accept in a NotExpression" in {
    val a = new VarDeclaration("a")
    a.run
    val newa = new Assignment("a", BoolValue(true))
    newa.run    
    val not = new NotExpression(a)

    val pretty = new PrettyPrinter()

    not.accept(pretty)

    pretty.str should be ("!true")
  }

 /* it should "print \"x = 3\" when we call accept in VarReference" in {
    val v3 = new VarDeclaration("v3")
    v3.run
    val newv3 = new Assignment("v3", IntValue(3))
    newv3.run
    val x = new VarReference("x")
    val oto_x = new Assignment("x", v3)
    oto_x.run()

    val pretty = new PrettyPrinter()

    x.accept(pretty)

    pretty.str should be ("x")
  }*/

  it should "print \"var x = 3\" when we call accept in Assignment" in {
    val v3 = new VarDeclaration("v3")
    v3.run
    val newv3 = new Assignment("v3", IntValue(3))
    newv3.run
    val x = new VarDeclaration("x")
    x.run
    val newx = new Assignment("x", v3)
    newx.run

    val pretty = new PrettyPrinter()

    newx.accept(pretty)

    pretty.str should be ("var x = 3")
  }

  it should "print \"if\" when we call accept in IFTHEN" in {
    val x = new VarDeclaration("x")
    x.run
    val a = new Assignment("x", IntValue(13))
    a.run
    
    val cond = new GrExpression(new VarReference("x"), IntValue(7))
    
    val cmd = new Assignment("x", new AddExpression(new VarReference("x"), IntValue(1)))
    
    val ift = new IfThen(cond, cmd)

    val pretty = new PrettyPrinter()

    ift.accept(pretty)

    pretty.str should be ("if(x > 7){var x = (x + 1)}")
  }

  it should "print \"Function\" when we call accept in function" in {
    val x = new VarDeclaration("x")
    x.run
    val a = new Assignment("x", IntValue(1))
    a.run
    val y = new VarDeclaration("y")
    y.run
    val b = new Assignment("y", IntValue(2))
    b.run

    val w1 = new AddExpression(new VarReference("x"), new VarReference("y"))
    
    val w2 = new Function("soma", List(("x", IntType()), ("y", IntType())), Return(w1))


    val pretty = new PrettyPrinter()
    w2.accept(pretty)

    pretty.str should be ("function soma(x,y){return (x + y)}")
    
  }

  it should "print \"Block command\" when we call accept in commands" in {
    val x = new VarDeclaration("x")
    x.run
    val a = new Assignment("x", IntValue(1))
    a.run
    val y = new VarDeclaration("y")
    y.run
    val b = new Assignment("y", IntValue(2))
    b.run

    val w1 = new AddExpression(new VarReference("x"), new VarReference("y"))
    val w2 = new Assignment("x", new AddExpression(new VarReference("x"), IntValue(1)))
    val w3 = new BlockCommand(List(w2, Return(w1)))

    val pretty = new PrettyPrinter()
    w3.accept(pretty)

    pretty.str should be ("var x = (x + 1)\nreturn (x + y)\n")
    
  }

  
}