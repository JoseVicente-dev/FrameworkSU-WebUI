package co.com.client.webproject.test.helpers;

public enum Seconds {

    ZERO_SECONDS(0),
    ONE_SECONDS(1),
    TWO_SECONDS(2),
    THREE_SECONDS(3),
    FOUR_SECONDS(4),
    FIVE_SECONDS(5),
    SIX_SECONDS(6),
    SEVEN_SECONDS(7),
    EIGHT_SECONDS(8),
    NINE_SECONDS(9),
    TEN_SECONDS(10),
    TWENTY_SECONDS(20),
    THIRTY_SECONDS(30),
    SIXTY_SECONDS(60);

    private final int value;

    Seconds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}