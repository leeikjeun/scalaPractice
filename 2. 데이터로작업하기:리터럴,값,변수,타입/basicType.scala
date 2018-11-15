/*
*  리터널이란 숫자, 문자 ,덱스트 처럼 소스 코드에 바로 등장하는 데이터를 뜻함
*  값은 불변의 타입을 갖는 저장 단위, 값이 정의 될 때 데이터가 할당될 수 있지만 절대 재할당은 불가
*  변수는 가변타입을 갖는 저장 단위
*  타입은 데이터의 종류
*/


// 기본적인 스칼라의 값 구문 val <name> : type = <literal>

var x : Int = 5

val greeting: String = "Hello, World"

val atSymbol: Char = '@'

// 값 할당을 기반으로 그 타압을 추론하는 것이 가능한 상황이라면 값의 정의에서 타입을 빼도 된다.

var x1 = 5

val greeting1 = "Hello, World"

val atSymbol1 = '@'

// 변수할당 키워드는 var <name> : type = <data> 형식
// 스칼라에서 관례상 변수보다 값을 선호하는데 이는 값을 사용하면 소스 코드가 안정적이며 예측가능하기 떄문

var x2: Int = 5
//or var x2 = 5

// 스칼라에서는 값과 변수를 정의할 때 사용하는 숫자타입과 아닌 타입으로 분류
// 핵심 타입은 객체 및 컬렉션을 포함하여 다른 모든 타입의 기본요소가 됨
// 자바와 c 와 달리 스칼라에서는 원시 데이터의 개념이 없다.
// 스칼라에서 형변환은 toType으로 가능

val l: Long = 20

val i: Int = l.toInt

/* 숫자 리터널들
  5 : int
  0x0f : int 16진수
  5l : Long
  5.0 : Double
  5f : Float
  5d : Double
*/


// 스칼라에서 문자열은 수학적 표기를 사용 ==연산자는 실제 두 값이 같은지를 비교한다.

val s1 = "Hello"

val matched = (s1 == "Hello")

val theme = "Na" * 16 + "Batmen!"

// 여러줄을 쓸때 큰따옴표 세개를 이용한다

val longString = """ she suggested reformatting the file
by replacing tabs (/t) with newline (\n);
"Why do that?", he asked. """
