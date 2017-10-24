/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pimplicit.design.pattern.context

import scala.concurrent.{ExecutionContext, Future}

/** Examples of Implicit context usage
  *
  * @author Yuriy Stul
  */
class ImplicitContext {

  def withoutImplicitContext(): Unit = {
    def getEmployee(id: Int)(e: ExecutionContext): Future[Employee] = ???

    def getRole(employee: Employee)(e: ExecutionContext): Future[Role] = ???

    val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

    ////////////////////////////////////////////////////////////////////////
    // Following expression 4 times directly specifies the execution context
    ////////////////////////////////////////////////////////////////////////
    // @formatter:off
    val bigEmployee: Future[EmployeeWithRole] =
      getEmployee(100)(ec).flatMap { e =>     // 1)
        getRole(e)(ec).map { r =>             // 2)
          EmployeeWithRole(e.id, e.name, r)
        }(ec)                                 // 3)
      }(ec)                                   // 4)
    // @formatter:on
  }

  def withImplicitContext(): Unit = {
    def getEmployee(id: Int)(implicit e: ExecutionContext): Future[Employee] = ???

    def getRole(employee: Employee)(implicit e: ExecutionContext): Future[Role] = ???

    import scala.concurrent.ExecutionContext.Implicits.global
    //////////////////////////////////////////////////////////////////////
    // Following expression doesn't specify directly the execution context
    //////////////////////////////////////////////////////////////////////
    val bigEmployee: Future[EmployeeWithRole] =
    getEmployee(100).flatMap(e =>
      getRole(e).map(r =>
        EmployeeWithRole(e.id, e.name, r)
      )
    )
  }

  case class Employee(id: Int, name: String)

  case class EmployeeWithRole(id: Int, name: String, r: Role)

  class Role

}
