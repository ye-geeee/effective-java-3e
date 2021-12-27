package src.아이템3_생성자나_열거_타입으로_싱글턴임을_보증하라;

public class Elvis1 {
    public static final Elvis1 INSTANCE = new Elvis1();

    private Elvis1() {
    }
}
