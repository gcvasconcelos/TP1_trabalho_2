package oberon.command

import oberon.Environment._

import oberon.expression.Expression
import oberon.expression.Expression
import oberon.expression.BoolValue
import oberon.expression.Value

trait Command {
  def run() : Unit 
}

class Return(val expression: Expression) extends Command {

  override 
  def run() : Value = {
    expression.eval()
  }

}

class BlockCommand(val cmds: List[Command]) extends Command {
  
  override
  def run() : Unit = {
    cmds.foreach(c => c.run())
  }
}

class While(val cond: Expression, val command: Command) extends Command {

  override
  def run() : Unit = {

    val v = cond.eval.asInstanceOf[BoolValue]
    println("ENVIRONMENT->" + stack)

    v match {
      case BoolValue(true) => { command.run(); this.run(); }
      case _               => { } 
    }
  }

}

class For(val control: Assignment, val cond: Expression, val iter: Command, val command: Command) extends Command{


  override 
  def run(): Unit = {
    val v = cond.eval.asInstanceOf[BoolValue]
    v match {
      case BoolValue(true) => { 
        control.run
        command.run
        iter.run
        this.run  
      }
      case _               => { }
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

class IfThenElse(val cond: Expression, val command: Command, val elseCommand: Command) extends Command {

  override 
  def run(): Unit = {
    val v = cond.eval.asInstanceOf[BoolValue]

    v match {
      case BoolValue(true) => command.run
      case _               => elseCommand.run
    } 
  }
  
}

