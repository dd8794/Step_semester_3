package week7.class_problems;

public class LockerCode {

    private final int lockerNumber;
    private String combinationCode;

    public LockerCode(
            int lockerNumber,
            String combinationCode) {

        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public boolean changeCode(
            String currentCode,
            String newCode) {

        if (!combinationCode.equals(currentCode)) {
            System.out.println("Code change rejected");
            return false;
        }

        combinationCode = newCode;

        System.out.println("Code changed successfully");
        return true;
    }

    public static void main(String[] args) {

        LockerCode locker =
                new LockerCode(101, "1234");

        locker.changeCode("1234", "5678");

        locker.changeCode("0000", "9999");
    }
}
