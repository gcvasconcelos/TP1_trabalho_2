// package oberon.visitor

// import oberon.expression._
// import oberon.command._
// import oberon._

// class PrettyPrinter extends Visitor {
//   var str = ""

//   def visit(e: Undefined)     : Unit = { str = "undefined" } 

//   def visit(e: IntValue)      : Unit = { str = e.value.toString }

//   def visit(e: BoolValue)     : Unit = { str = e.value.toString }

//   def visit(e: AddExpression) : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " + " + r + ")" 
//   }
  
//   def visit(e: SubExpression) : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " - " + r + ")" 
//   }

//   def visit(e: MultExpression) : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " * " + r + ")" 
//   }

//   def visit(e: DivExpression) : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " / " + r + ")" 
//   }

//   def visit(e: ModExpression) : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " % " + r + ")" 
//   }

//   def visit(e: EqExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " == " + r + ")" 
//   }

//   def visit(e: LeExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " <= " + r + ")" 
//   }

//   def visit(e: GeExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " >= " + r + ")" 
//   }

//   def visit(e: LoExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " < " + r + ")" 
//   }

//   def visit(e: GrExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " > " + r + ")" 
//   }

//   def visit(e: NeqExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " != " + r + ")" 
//   }

//   def visit(e: AndExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " && " + r + ")" 
//   }

//   def visit(e: OrExpression)  : Unit = {
//     val (l, r) = visitBinExp(e)
//     str = "(" + l + " || " + r + ")" 
//   }

//   def visit(e: NotExpression)  : Unit = {
//     val exp = visitExp(e)
//     str = "!" + exp
//   }

//   def visit(c: Return)  : Unit = {
//     val exp = visitCommand(c)
//     str = "return " + exp
//   }

//   def visit(c: BlockCommand)  : Unit = {
//     c.cmds.foreach(cmd => str += visitCommand(cmd) + "\n")
//   } 

//   def visit(c: While)         : Unit = { 
//     val exp = visitExp(c.cond)
//     val cmd = visitCommand(c.command)
    
//     str = "while" + exp + "\n" + "{"  + cmd + "}"
//   } 

//   def visit(c: Print)         : Unit = { 
//     val exp = visitExp(c.exp)
//     str = exp
//   } 
  
//   def visit(c: OberonProgram) : Unit = { 
    
//   }  
  
//   def visit(e: VarReference)        : Unit = { }  

//   private def visitBinExp(e: BinExpression) : (String, String) = {
//     e.lhs.accept(this)
//     val l = str

//     e.rhs.accept(this)
//     val r = str

//     return (l, r) 
//   }

//   private def visitExp(e: Expression): String = {
//     e.accept(this)
//     val exp = str

//     return exp 
//   }

//   private def visitCommand(c: Command): String = {
//     c.accept(this)
//     val cmd = str

//     return cmd 
//   }
// }