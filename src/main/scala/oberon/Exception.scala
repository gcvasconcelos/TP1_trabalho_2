package oberon

case class VariableAlreadyDeclared(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

case class VariableNotDeclared(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

case class FunctionNotDeclared(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

case class ProcedureNotDeclared(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

case class ReturnNotFound(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)
