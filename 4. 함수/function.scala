// 스칼라에서 함수는 이름을 가진 재활용 가능한 표현식이다.
// 매개변수화된 함수를 사용하면 중복된코드를 정규화 혹은 로직을 단순화하고 로직이 발전을 더 쉽게 해준다.
// 위의 내용은 순수 함수를 구성하면 보다 더 휼룡한 이점을 얻을수 있다.
/*
  순수 함수 특징
  1. 하나 또는 그 이상의 입력 매개변수를 가짐
  2. 입력 매개변수만을 가지고 계산을 수행
  3. 값을 반환한다.
  4. 동일 입력에 대해 항상 같은 값을 반환한다.
  5. 함수 외부의 어떤 데이터도 사용하거나 영향을 주지 않는다.
  6. 함수 외부 데이터에 영향받지 않는다.

  순수 함수만으로 DB, 소켓, 전역변수등을 가지는 애플리케이션을 만들수 없다.
  따라서 스칼라는 어느정도 수준에서 절충하고 순수하지 않은 함수의 수를 줄이는 방법을 강구한다.
*/

// 함수 표현식 <함수 식별자> <함수 표현식>

def formatEuro(ant: Double) = f"E$ant%.2f"

formatEuro(3.4645)

formatEuro {val rate = 1.32; 0.235 + 0.7123 + rate * 5.32}


// 재귀 함수

def power(x: Int, n: Int) : Long = {
  if(n >= 1) x * power(x, n - 1)
  else 1
}

power(2, 8)

// 스택 오버플로우를 방지하는 방법 꼬리-재귀
// 꼬리-재귀 방식을 사용하면 새로운 스택 공간을 생성하지 않는 대신 현행 함수의 스택 공간을 사용한다.

@annotation.tailrec
def power(x:Int, n:Int, t:Int = 1): Long = {
  if( n < 1 ) t
  else power(x, n-1, x*t)
}
// 재귀의 마지막은 그대로 결과값을 받는 식으로 해야 재귀함수를 최적화하는 꼬리-재귀 방식을 사용할 수 있다.
power(2, 8)

//중첩 함수

def max(a: Int, b: Int, c: Int) : Int = {
  def max(x : Int, y : Int) = if(x > y) x else y
  max(a,max(b,c))
}

max(42,181,19)

//이름으로 매개변수를 지정하여 함수 호출하기
// <함수명> (<매개변수> = <값>)

def greet(prefix: String, name: String) = s"$prefix $name"

val greeting1 = greet("Ms", "Brown")

val greeting2 = greet(name = "Brown", prefix = "Mr")

//가변 매개 변수
// 정해지지 않는 개수의 입력 인수를 함수로 작동 가능하게 함
// 인자에 *를 추가하면됨

def sum(items: Int*): Int = {
  var total = 0;
  for (i <- items) total += i;
  total
}

sum(10,20,30,40,50)

//매개변수 그룹
//각 매개변수 그릅을 괄호로 구분되게 하는 방식

def max(x:Int)(y:Int) = {
  if(x > y) x else y
}

max(5)(4)

//타입 매개변수
// 값 매개변수를 보완하기 위해 값 매개변수 또는 반환값에 사용될 타입을 지시하는 타입을 타입 매개변수라 한다
// 정의 def <함수명>[타입명](<매개변수 이름> : <타입명>) : <타입명>

def identity[A](a:A) : A = a

val s: String = identity[String]("Hello")
val d: Int = identity[Int](5)

val s = identity[String]("Hello")
val d = identity[Int](5)

val s = identity("Hello")
val d = identity(5)

// 타입 매개변수는 추론하여 값을 설정할수 있으나 일반적으로 이는 가장 가독성있는 방식이 아닐 수 있다.


// 메소드와 연산자
// 메소드를 호출하는 법은 삽입점 표기법이다. <클래스 인스턴스>.<메소드>[<매개변수>]

val s = "vacation.jpg"

val isJPEG = s.endsWith(".jpg")
