package oberon.expression

import oberon.Environment._
import oberon.command._
import oberon.visitor._
import oberon._

class Function(val name: String, val args: List[Expression]) extends Expression{

  override 
  def eval(): Value = {  
    val function = lookupFunction(name) match {
      case Some(function) => function
      case _              => throw FunctionNotDeclared() 
    }

    push
    var i = 0
    args.foreach { arg => 
      val (_type, _var) = function.params(i)
      new VarDeclaration(_var).run
      new Assignment(_var, arg).run
      i = i + 1
    }
    function.command.run

    var _return: Value = Undefined()

    function.command match {
      case Return(exp)       => _return = exp.eval
      case cmd: BlockCommand => _return = cmd.cmds.last.asInstanceOf[Return].expression.eval
      case _                 => throw ReturnNotFound()
    }
    pop
    _return
  }

  override 
  def accept(v : Visitor): Unit = v.visit(this) 

  override 
  def calculateType(): Type = {
    val function = lookupFunction(name) match {
      case Some(function) => function
      case _              => throw ProcedureNotDeclared()
    }

    var i = 0
    args.foreach { arg =>
      val (_type, _var) = function.params(i)
      if (_type != arg.calculateType) {
        return UndefinedType()
      }
      i = i + 1
    }

    if (!function.command.typeCheck) {
      return UndefinedType()
    }
    
    val _return = function.command match {
      case cmd: Return       => cmd
      case cmd: BlockCommand => cmd.cmds.last.asInstanceOf[Return]
      case _                 => throw ReturnNotFound()
    }

    _return.expression.calculateType == function.returnType match {
      case true => function.returnType
      case _    => UndefinedType() 
    }
  }

}