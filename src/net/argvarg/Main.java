package net.argvarg;


import java.util.Scanner;

public class Main {

    public static int debugLevel = 0;
    public static void main(String[] args) {
	    Main start = new Main();
        start.run();
    }

    public String[] commlog = new String[10];
    public Boolean[][][][][] cases = new Boolean[5][5][5][5][5];
    public String[] people = new String[5];
    public Scanner reader = new Scanner(System.in);
    public String input;
    public String[] splitinput;
    public int currperson;
    public int persontwo;
    public int commnum;

    public void run() {
        cases = (Boolean[][][][][])ArrayHelper.setAll(cases, null);
        cases = (Boolean[][][][][])ArrayHelper.setDiff(cases, true);
        for (int i = 0; i < 6; i++) {
            getInput();
            commlog[i] = people[currperson] + getComm(commnum) + splitinput[splitinput.length - 1];
            if (commnum == 1) {
                commlog[i] = commlog[i] + " OR " +splitinput[splitinput.length - 3];
            }
            if (debugLevel > 0) System.out.println(commlog[i]);
        }
        int[] answer = getAnswer();
        System.out.println("5. " + people[answer[4]]);
        System.out.println("4. " + people[answer[3]]);
        System.out.println("3. " + people[answer[2]]);
        System.out.println("2. " + people[answer[1]]);
        System.out.println("1. " + people[answer[0]]);
        System.exit(0);
    }

    protected int[] getAnswer() {
        int[] correct = new int[5];
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                            Integer[] indexes = {a, b, c, d, e};
                            if (cases[a][b][c][d][e] != null && !(ArrayHelper.anyEqual(indexes, 5))) {
                                correct[a] = 0;
                                if (debugLevel > 0)System.out.println(a);
                                correct[b] = 1;
                                if (debugLevel > 0) System.out.println(b);
                                correct[c] = 2;
                                if (debugLevel > 0) System.out.println(c);
                                correct[d] = 3;
                                if (debugLevel > 0) System.out.println(d);
                                correct[e] = 4;
                                if (debugLevel > 0) System.out.println(e);
                            }
                        }
                    }
                }
            }
        }
        return correct;
    }

    public void getInput() {
        input = reader.nextLine();
        splitinput = input.split(" ");
        currperson = identify(splitinput[0]);
        commnum = commID(input);
        if ((commnum == 0) || (commnum == 1)) {
            int floor = Integer.parseInt(splitinput[splitinput.length - 1]);
            discount(currperson, floor, 0);
            if (commnum == 1) {
                floor = Integer.parseInt(splitinput[splitinput.length - 3]);
                discount(currperson, floor, 1);

            }
        } else if (commnum == 2) {
            persontwo = identify(splitinput[splitinput.length - 1]);
            discount(currperson, persontwo, 2);
        } else if (commnum == 3) {
            persontwo = identify(splitinput[splitinput.length - 1]);
            discount(currperson, persontwo, 3);
        } else if (commnum == 4) {
            persontwo = identify(splitinput[splitinput.length - 1]);
            discount(currperson, persontwo, 4);
        } else System.exit(3);
    }

    public void discount (int person, int val2, int operation) {
        int[] a = new int[5];
        if (debugLevel > 0) System.out.printf("Process %d is occurring \n", operation);
        if ((operation == 0) || (operation == 1)) {
            if ((a[0] == 2) && (a[1] == 1) && (a[2] == 3) && (a[3] == 4) &&(a[4] == 0)) System.out.println("correct answer was discounted due to " + operation);
            cases = (Boolean[][][][][])ArrayHelper.setAll(cases, val2 - 1, person, null);
        } else if ((operation == 2) || (operation == 3) || (operation == 4)) {
            for (a[0] = 0; a[0] < 5; a[0]++) {
                for (a[1] = 0; a[1] < 5; a[1]++) {
                    for (a[2] = 0; a[2] < 5; a[2]++) {
                        for (a[3] = 0; a[3] < 5; a[3]++) {
                            for (a[4] = 0; a[4] < 5; a[4]++) {
                                if ((operation == 2) && (a[person] < a[val2])) {
                                    if (debugLevel >= 2) System.out.printf("%d, %d, %d, %d, %d, was DISCOUNTED\n", a[0], a[1], a[2], a[3], a[4]);
                                    if ((a[0] == 2) && (a[1] == 1) && (a[2] == 3) && (a[3] == 4) &&(a[4] == 0) && (debugLevel >= 1)) System.out.println("correct answer was discounted due to " + operation);
                                    cases[a[0]][a[1]][a[2]][a[3]][a[4]] = null;
                                } else if ((operation == 3) && !((a[person] - 1 == a[val2]) || (a[person] + 1 == a[val2]))) {
                                    if (debugLevel >= 2) System.out.printf("%d, %d, %d, %d, %d, was DISCOUNTED\n", a[0], a[1], a[2], a[3], a[4]);
                                    if (debugLevel > 0) System.out.println("Boo");
                                    if ((a[0] == 2) && (a[1] == 1) && ((a[2] == 3) && (a[3] == 4) &&(a[4] == 0)) && (debugLevel >= 1)) System.out.println("correct answer was discounted due to " + operation);
                                    cases[a[0]][a[1]][a[2]][a[3]][a[4]] = null;
                                } else if ((operation == 4) && ((a[person] - 1 == a[val2]) || (a[person] + 1 == a[val2]))) {
                                    if (debugLevel >= 2) System.out.printf("%d, %d, %d, %d, %d, was DISCOUNTED\n", a[0], a[1], a[2], a[3], a[4]);
                                    if (debugLevel > 0) System.out.println("Baa");
                                    if ((a[0] == 2) && (a[1] == 1) && (a[2] == 3) && (a[3] == 4) &&(a[4] == 0) && (debugLevel >= 1)) System.out.println("correct answer was discounted due to " + operation);
                                    cases[a[0]][a[1]][a[2]][a[3]][a[4]] = null;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int identify (String name) {
        for (int i = 0; i < 5; i++) {
            if (people[i] == null) {
                people[i] = name;
                return i;
            } else if (people[i].equals(name)) {
                return i;
            } else if (i == 4) {
                System.out.println("testing");
                System.out.println(people[0] + people[1] + people[2] + people[3] + people[4]);
            }
        }
        System.exit(2);
        return -1;
    }

    public String getComm (int input) {
        switch (input) {
            case 0: return Constants.comm1;
            case 1: return Constants.comm2;
            case 2: return Constants.comm3;
            case 3: return Constants.comm4;
            case 4: return Constants.comm5;
            default: return "SYNTAX ERROR: Command not found";
        }
    }

    public int commID (String input) {
        if (input.contains(Constants.comm1)) {
            return 0;
        } else if (input.contains(Constants.comm2)) {
            return 1;
        } else if (input.contains(Constants.comm3)) {
            return 2;
        } else if (input.contains(Constants.comm5)) {
            return 4;
        } else if (input.contains(Constants.comm4)) {
            return 3;
        } else {
            return -1;
        }
    }


}
