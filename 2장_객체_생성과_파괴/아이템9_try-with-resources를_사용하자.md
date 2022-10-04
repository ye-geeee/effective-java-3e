# try-finally

전통적으로 자원이 제대로 닫힘을 보장하기 위해서는 `try-finally`가 쓰였다.
하지만 해당 방식은 아래와 같이 두 가지 문제점이 있다.

## 문제점

1. 자원이 많아질 수록 `try` 중첩문이 발생하여 복잡해진다.
2. 아래 예시에서 `try` 문에서 `exception` 이 발생할 경우, `finally` 문에서도 `exception` 이 발생한다. 그럼 `finally` 문의 로그만 남아 실제로 `try` 문에서 난 에러는 surpressed 되며, 디버깅하기가 힘들어진다.

```
try {
    return br.readLine();
} finally {
    br.close();
}
```

실제고, 2007년 당시 자바 라이브러리에서 `close` 를 제대로 구현한 비율은 3분의 1정도라고 한다.

# try-with-resources

이에 대한 대안으로 나온 것이 `try-with-resources` 다.
이것이 얼마나 편리한가하면!!!!!!!
`AutoCloseable` 인터페이스를 구현한 자원에 대해서는 자동으로 `try` 문이 종료되면 자원을 `close` 해준다.
코드는 아래와 같이 작성이 가능하다!

```
class SampleResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("2. BYE BYE Angry~~~");
    }
}

public class Main {
    public static void main(String[] args) {
        try (SampleResource sampleResource = new SampleResource()) {
            System.out.println("1. I'm Angry !!!!!!");
        } catch (Exception e) {
        }
        System.out.println("3. I'm not Angry !!!!!!");
    }
}
```

`try` 안에다가 자원을 생성해주면 자동으로 `close` 까지!!!

수행시키면 결과는 아래와 같다.

```
1. I'm Angry !!!!!!
2. BYE BYE Angry~~~
3. I'm not Angry !!!!!!
```

그러니 앞으로는 자원을 회수해야할 때는, 무조건!
`try-finally` 가 아닌 `try-with-resources` 를 사용하자!!!!
