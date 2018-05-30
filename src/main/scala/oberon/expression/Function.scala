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

    push()
    var i = 0
    args.foreach { arg => 
      new Assignment(function.params(i), arg).run()
      i = i + 1
    }

    val _return: Value = Undefined()

    function.command match {
      case cmd: Command      => cmd.asInstanceOf[Return].run()  
      case cmd: BlockCommand => cmd.cmds.last.asInstanceOf[Return].run()
    }
    
    _return
  }

}