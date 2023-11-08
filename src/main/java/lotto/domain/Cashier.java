package lotto.domain;

public class Cashier {
    private final long purchaseAmount;

    public Cashier(String purchaseAmount) {
        checkIsDigit(purchaseAmount);
        long number = Integer.parseInt(purchaseAmount);
        checkIsDivisibleByThousand(number);
        this.purchaseAmount = number;
    }

    private void checkIsDigit(String input) {
        char[] characterizedInput = input.toCharArray();
        for (char number : characterizedInput) {
            if (number < '0' || number > '9') {
                throw new NotDigitException();
            }
        }
    }

    private void checkIsDivisibleByThousand(long number) {
        if (number == 0 || number % 1000 != 0) {
            throw new NotDivisibleByThousandException();
        }
    }

    public long getPurchaseAmount() {
        long purchaseAmount = this.purchaseAmount;
        return purchaseAmount;
    }

}
