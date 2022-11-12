package lotto.VO;

import java.util.Arrays;

/*
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
* */
public enum LottoPrice {
    NO_REWARD(6,0, false, "당첨되지 않았습니다. - %d개\n", 0),
    FIFTH( 5,3, false, "3개 일치 (5,000원) - %d개\n", 5_000),
    FORTH( 4,4, false, "4개 일치 (50,000원) - %d개\n", 50_000),
    THIRD( 3,5, false, "5개 일치 (1,500,000원) - %d개\n", 1_500_000),
    SECOND( 2,5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30_000_000),
    FIRST( 1,6, false, "6개 일치 (2,000,000,000원) - %d개\n", 2_000_000_000);

    private int rank;
    private int match;
    private boolean bonus;
    private String message;
    private long price;

    LottoPrice(int rank, int match, boolean bonus, String message, long price) {
        this.rank = rank;
        this.match = match;
        this.bonus = bonus;
        this.message = message;
        this.price = price;
    }

    public static LottoPrice find(int match, boolean bonus){

        if(match != 5){
            bonus = false;
        }

        for (LottoPrice value : values()) {
            if(value.match == match && value.bonus == bonus){
                return value;
            }
        }

        return NO_REWARD;
    }

    public static LottoPrice findByRank(int rank){
        return Arrays.stream(values()).filter(lottoPrice -> lottoPrice.rank == rank).findAny().orElse(NO_REWARD);
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getMessage() {
        return message;
    }

    public long getPrice() {
        return price;
    }


}
