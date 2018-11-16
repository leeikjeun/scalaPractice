/*
  표현식은 실행 후 값을 반환하는 코드 단위를 말함
  한 줄 이상의 코드를 중괄호로 묶으면 하나의 표현식으로 간주 이를 표현식 블록이라 한다.
*/


// 기본적인 표현식

"hello"

"hel" + "l" + "o"

// 표현식으로 값과 변수 정의하기
// 구문 val <식별자>[:타입] = <표현식>
// 구문 var <식별자>[:타입] = <표현식>
// 위의 내용은 값으나 다만 반환되는 값이 값이냐 혹은 변수냐의 차이

val amount = {
  val x = 5 * 20;
  x + 10
}

// 밑의 코드와 같이 중복도 가능
{val a = 1; {val b = a * 2; { val c = b + 4; c }}}


// 문장은 값을 반환하지 않은 표현식이다. 문장의 반환 타입은 값이 없을을 나타내는 Unit이
val x = 1


// if .. else 표현식 블록
// 스칼라는 if 와 else만 지원을하며 else if문은 없다.
// if 표현식 if(<부울식>) <표현식>

if( 47 % 3 > 0) println("Not a multiple of 3")

//독자적인 if문 사용시 조건문이 반대일때 반환은 Any type으로 반환이 된다.

val x = 10
val y = 20

val max = if (x > y) x else y

//스칼라는 삼항표현식이 없다 만약 if else문으로 해결 안될시 매치 표현식을 사용해야한다.
//매치 표현식은 C언어의 swich문과 비슷하다. 다른점 break가 필요없다. swich문과 비교해서 다양하게 비교할수있다.
/*매치 표현식 구문
  match {
    case <패턴 매치> => <표현식>
    [case...]
    case _ => <표현식> // 와일드카드 매칭
  }
  // 스칼라는 공식적으로 =>를 따라가는 다중 표현식을 지원하지만 가독성이 떨어짐으로 권장하지 않는다.
  // 구문 패턴 대안도 가능 예) <패턴 1> | <패턴 2> => someData Or someFunction
  // 와일드카드 매칭은 하나도 맞는 패턴이 없을 경우 발생한다.
*/

val max = x > y match{
  case true => x
  case false => y
}

val response: String = null

response match{
  case s if s != null => println(s"Received '$s'")
  case s => println("Error")
}

val x = 123
val y: Any = x;


y match{
  case x: Int => println(s"{$x}" +  "is Int")
  case x: String => println(s"{$x}" +  "is String")
  case _ => println("null")
}
