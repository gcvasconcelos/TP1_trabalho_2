package oberon.expression

import oberon.Environment._
import oberon.command.Assignment
import oberon.command._
import oberon._

class Function(name: String, args: List[Expression]) extends Expression{

  override 
  def eval(): Value = {  
    val function = lookupFunction(name) match {
      case Some(function) => function
      case _              => throw FunctionNotDeclared() 
    }

    push
    var i = 0
    args.foreach { arg => 
      new VarDeclaration(function.params(i)).run
      new Assignment(function.params(i), arg).run
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

}