package oberon.command

import oberon.Environment._

import oberon.expression.Expression
import oberon.expression.BoolValue

trait Command {
  def run() : Unit 
}


class BlockCommand(val cmds: List[Command]) extends Command {
  
  override
  def run() : Unit = {
    cmds.foreach(c => c.run())
  }
}

class Assignment(val id: String, val expression: Expression) extends Command {

  override
  def run() : Unit = {
    map(id, expression.eval())
  }

}

class While(val cond: Expression, val command: Command) extends Command {

  override
  def run() : Unit = {

    val v = cond.eval.asInstanceOf[BoolValue]

    v match {
      case BoolValue(true) => { command.run(); this.run(); }
      case _               => { } 
    }
  }

}

class For(val control: Command, val cond: Expression, val iter: Command, val command: Command) extends Command{

  override 
  def run(): Unit = {
    val v = cond.eval.asInstanceOf[BoolValue]
    control.run
    v match {
      case BoolValue(true) if true => { 
        command.run
        iter.run
        this.run  
      }
      case _ => {}
    }
  }

}

class Print(val exp: Expression) extends Command {
  override
  def run() : Unit = {
    print(exp.eval())
  }

}

class IfThen(val cond: Expression, val command: Command) extends Command {
  
  override 
  def run(): Unit = {
    val v = cond.eval.asInstanceOf[BoolValue]

    v match {
      case BoolValue(true) => command.run
      case _               => { }
    }
  }

}
