package oberon.command

case class VariableAlreadyDeclared(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

case class VariableNotDeclared(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)
