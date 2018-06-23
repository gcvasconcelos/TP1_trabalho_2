package oberon

import oberon.command.Command

class OberonProgram(val cmd: Command) extends Command {

  override
  def run() : Unit = {
    cmd.run()
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
