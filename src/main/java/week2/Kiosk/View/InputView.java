package week2.Kiosk.View;

import week2.Kiosk.Util.Print;
import week2.Kiosk.domain.dto.CommandDto;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    // 기능 구현
    public CommandDto readCommand() {
        Scanner sc = new Scanner(System.in);
        Print.gameStart();

        String command = sc.nextLine().toUpperCase();
        return new CommandDto(command);
    }

    public String readProductInfo() {
        Print.categoryType();

        return sc.next();
    }
}
