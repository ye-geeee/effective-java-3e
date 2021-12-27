package src.아이템3_생성자나_열거_타입으로_싱글턴임을_보증하라;

public class Elvis2 {
    private static final Elvis2 INSTANCE = new Elvis2();

    private Elvis2() {
    }

    public static Elvis2 getInstance() {
        return INSTANCE;
    }

}
