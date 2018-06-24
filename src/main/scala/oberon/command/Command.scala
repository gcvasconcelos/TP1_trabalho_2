package oberon.command

import oberon.Environment._
import oberon.expression._
import oberon.visitor._


trait Command extends Visitable{
  def run() : Unit 
  def typeCheck(): Boolean
}

class BlockCommand(val cmds: List[Command]) extends Command {
  
  override
  def run() : Unit = {
    cmds.foreach(cmd => cmd.run())
  }

  override 
  def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = cmds.forall(cmd => cmd.typeCheck)

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

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = {
    cond.calculateType == BoolType() && command.typeCheck
  }

}

class Print(val exp: Expression) extends Command {
  override
  def run() : Unit = {
    print(exp.eval())
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = true

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

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = {
    cond.calculateType == BoolType() && command.typeCheck
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

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = {
    cond.calculateType == BoolType() && command.typeCheck && elseCommand.typeCheck
  }
  
}

case class Return(val expression: Expression) extends Command {

  override 
  def run() : Unit = { }

  override def accept(v : Visitor): Unit = v.visit(this)

  override def typeCheck(): Boolean = expression.typeCheck

}