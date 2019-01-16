package ${PACKAGE_NAME}

import org.scalatest.FunSuite
import org.scalatest.Matchers
#set( $m = $NAME.replace("_Test", ""))
import ${PACKAGE_NAME}.$m._

class ${NAME} extends FunSuite with Matchers {

  test("1") {
    """""".solveVal shouldEqual ???
  }

}
