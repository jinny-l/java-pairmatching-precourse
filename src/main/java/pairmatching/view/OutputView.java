package pairmatching.view;

public class OutputView {

    private OutputView() {
    }

    public static void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
