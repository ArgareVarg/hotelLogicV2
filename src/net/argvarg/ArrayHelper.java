package net.argvarg;

/**
 * Created by fredrik on 11/1/14.
 */
public class ArrayHelper {
    public static Object[][][][][] setAll (Object[][][][][] myobj, int index, int indexNum, Object value) {
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {
                        switch(indexNum) {
                            case 0: myobj[index][a][b][c][d] = value;
                                if (Main.debugLevel >= 3) System.out.printf("%d, %d, %d, %d, %d.\n", index, a, b, c, d);
                                break;
                            case 1: myobj[a][index][b][c][d] = value;
                                if (Main.debugLevel >= 3) System.out.printf("%d, %d, %d, %d, %d.\n", a, index, b, c, d);
                                break;
                            case 2: myobj[a][b][index][c][d] = value;
                                if (Main.debugLevel >= 3) System.out.printf("%d, %d, %d, %d, %d.\n", a, b, index, c, d);
                                break;
                            case 3: myobj[a][b][c][index][d] = value;
                                if (Main.debugLevel >= 3) System.out.printf("%d, %d, %d, %d, %d.\n", a, b, c, index, d);
                                break;
                            case 4: myobj[a][b][c][d][index] = value;
                                if (Main.debugLevel >= 3) System.out.printf("%d, %d, %d, %d, %d.\n", a, b, c, d, index);
                                break;
                            default: System.exit(2);
                        }
                    }
                }
            }
        }
        return myobj;
    }

    public static Object[][][][][] setDiff (Object[][][][][] myobj, Object value) {
        Integer[] test = new Integer[5];
        for (test[0] = 0; test[0] < 5; test[0]++) {
            for (test[1] = 0; test[1] < 5; test[1]++) {
                for (test[2] = 0; test[2] < 5; test[2]++) {
                    for (test[3] = 0; test[3] < 5; test[3]++) {
                        for (test[4] = 0; test[4] < 5; test[4]++) {
                            if(!(anyEqual(test, 5))) {
                                myobj[test[0]][test[1]][test[2]][test[3]][test[4]] = value;
                            }
                        }
                    }
                }
            }
        }
        return myobj;
    }

    public static boolean anyEqual (Object[] myObj, int indexNum) {
        for (int a = 0; a < indexNum; a++) {
            for (int b = 0; b < indexNum; b++) {
                if ((a != b) && (myObj[a] == myObj[b])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Object[][][][][] setAll(Object[][][][][] myobj, Object value) {
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                            myobj[a][b][c][d][e] = value;
                        }
                    }
                }
            }
        }
        return myobj;
    }

    public static void setAll (Object[] myobj, Object value) {
        for (int e = 0; e < 5; e++) {
            myobj[e] = value;
        }
    }
}
