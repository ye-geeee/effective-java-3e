# 아이템 4. 인스턴스화를 막으려거든 private 생성자를 사용하라

### 언제 인스턴스화를 막는 것이 필요할까?

1. 단순히 정적 메서드와 정적 필드만을 담은 클래스를 만들고 싶을 때 사용한다.
2. 특정 인터페이스를 구현하는 객체를 생성해주는 정적 메서드(혹은 팩터리)를 모아놓는다.
   - 예를 들면, `java.lang.Math`, `java.util.Arrays', `java.util.Collections`  
3. final 클래스와 관련한 메서드들을 모아놓을 때 사용한다.  
   - final 클래스를 상속해서 하위 클래스에 메서드를 넣는 것은 불가능하다.  
    
### 그럼 어떻게 인스턴스화를 막을 수 있을까?

생성자를 명시하지 않으면 컴파일러가 자동으로 기본 생성자를 만들어준다.  
실제로 공개된 API들에서도 이처럼 의도치 않게 인스턴스화를 할 수 있게 된 클래스가 종종 있다.

**추상 클래스로 만드는 것은 인스턴스화를 막을 수 없다.**  
하위 클래스를 만들어 인스턴스화를하면 그만이다.  

따라서, **private 생성자를 추가하여 클래스의 인스턴스화를 막을 수 있다.**  
명시적 생성자가 private이라 클래스 바깥에서 접근할 수 없다.  
그리고 상속을 불가능하게 하는 효과도 있다.  
모든 생성자는 명시적이든 묵시적이든 상위 클래스의 생성자를 호출하게 되는데,  
이를 private으로 선언했으니 하위 클래스가 상위 클래스의 생성자에 접근할 길이 막혀버린다.  

