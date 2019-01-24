package pl.aj.uamproject.hairdresser.service;

public class DiscountService {
    private final static int EveryNthResultToGetDiscount = 10;

    public boolean hasDiscount(int n){
        return (n > 0 && (n % EveryNthResultToGetDiscount) == 0);
    }

}
