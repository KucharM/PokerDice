package dice;

public class ScoreComparator {
    private int[] score1;
    private int[] score2;

    public ScoreComparator(ListOfDice list1, ListOfDice list2) {
        this.score1 = list1.getDiceListValue();
        this.score2 = list2.getDiceListValue();
    }

    public String showScore() {
        int count6 = 0, count5 = 0, count4 = 0, count3 = 0, count2 = 0, count1 = 0;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Score: ");
        for (int i: score1){
            if (i == 6)
                count6++;
            else if (i == 5)
                count5++;
            else if (i == 4)
                count4++;
            else if (i == 3)
                count3++;
            else if (i == 2)
                count2++;
            else
                count1++;
        }

        return "score is: sixex " + count6 + "\nfives " + count5 + "\nfours: " + count4 +
                "\nthrees: " + count3 + "\ntwos: " + count2 + " \nones: " + count1;
    }

    public static void main(String[] args) {
        ListOfDice list1 = new ListOfDice();
        ListOfDice list2 = new ListOfDice();

        ScoreComparator scoreComparator = new ScoreComparator(list1, list2);
        scoreComparator.showScore();
    }
}

