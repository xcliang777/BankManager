import javax.swing.*;

public class Tools {

    public static final String ERROR_NOT_NUMBER = "Only number is accepted Here";
    public static final String ERROR_NOT_CORRECT_RANGE = "Invalid number";
    public static final String ERROR_EMPTY_STRING = "Empty id is not accepted";
    public static final String ERROR_DUPLICATE_STRING = "Id you enter is already used by other customer";


    public static boolean checkStringIsNumberWithRange(String s, int low, int high, JFrame parent ) {
        if (!checkStringNumber(s)) {
            errorPanel("Input Error", ERROR_NOT_NUMBER, parent);
            return false;
        } else {
            int value = Integer.parseInt(s);
            if (value < low || value > high) {
                System.out.println((value < low) + "" + (value > high));
                errorPanel("Input Error", ERROR_NOT_CORRECT_RANGE, parent);
                return false;
            }
        }
        return true;
    }

    public static boolean checkString(String s, JFrame parent ) {
        if (s.length() == 0) {
            errorPanel("Input Error", ERROR_EMPTY_STRING, parent);
            return false;
        }
        return true;
    }

    public static void errorPanel(String title, String content, JFrame parent) {
        JOptionPane.showConfirmDialog(parent, content, title, JOptionPane.DEFAULT_OPTION);
    }

    private static boolean checkStringNumber(String s) {
        if (s.length() != 0) {
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkStringNumber("123"));
    }

}
