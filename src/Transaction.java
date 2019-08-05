import java.util.ArrayList;

public class Transaction {

    private ArrayList<String> transactions;
    private int offset;

    public Transaction() {
        transactions = new ArrayList<>();
        offset = -1;
    }

    public void addTransaction(String s){
        transactions.add(s);
    }

    public String generateReportWithReset(boolean all) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < transactions.size(); i++) {
            if (i <= offset && !all) continue;
            else {
                stringBuilder.append(transactions.get(i));
                stringBuilder.append(i == transactions.size()-1 ? "" : "\n");
            }
        }
        offset = transactions.size()-1;
        return stringBuilder.toString();
    }
}
