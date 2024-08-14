import java.util.Scanner;

public class Program {

    static String[] weekDays = { "MO", "TU", "WE", "TH", "FR", "SA", "SU" };
    static Scanner sc = new Scanner(System.in);
    static String input;
    static String[] students = new String[10];

    static String[] weekClasses = new String[10];
    static String[][] attendanceRecord = new String[10][4];
    static int[] time = new int[10];
    static String[] times = new String[10];

    public static void printList(String[] list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static boolean containsSpaces(char[] name) {
        for (char c : name) {
            if (c == ' ') {
                return true;
            }
        }
        return false;
    }

    public static String[] getStudentsList() {
        int i = 0;
        while (true) {
            input = sc.nextLine();
            if (input.equals(".")) {
                break;
            }
            if (i > 9) {
                System.err.println("max number of students allowed is 10");
                System.exit(-1);
            }
            students[i] = input;
            if (students[i].length() > 10 || containsSpaces(students[i].toCharArray())) {
                System.err.println("Student name should not exceed 10 characters or contain spaces");
                System.exit(-1);
            }
            i++;
        }
        return (getUpdatedArray(students));
    }

    public static void getDaysAndTime() {
        int i = 0;
        while (true) {
            int t = 0;
            input = sc.nextLine();
            String days = "";
            if (input.equals(".")) {
                break;
            }
            if (i > 9) {
                System.err.println("max number of classes allowed is 10");
                System.exit(-1);
            }
            char[] inputChars = input.toCharArray();
            boolean numberPartCompleted = false;
            for (int j = 0; j < inputChars.length; j++) {
                char c = inputChars[j];

                if (c >= '0' && c <= '9' && !numberPartCompleted) {
                    t = t * 10 + (c - '0');
                } else {
                    numberPartCompleted = true;
                    if (c != ' ') {
                        days += c;
                    }
                }
            }
            if (t < 1 || t > 6) {
                System.err.println("The time should be between 1 PM and 6 PM");
                System.exit(-1);
            }
            weekClasses[i] = days;
            time[i] = t;
            i++;
        }
        weekClasses = getUpdatedArray(weekClasses);
    }

    public static String[][] getAttendanceRecord() {
        int i = 0;
        while (true) {
            int j = 0;
            boolean dot = false;
            while (j < 4) {
                input = sc.next();
                if (input.equals(".")) {
                    dot = true;
                    break;
                }
                attendanceRecord[i][j] = input;

                j++;
            }
            if (dot) {
                break;
            }
            i++;
        }
        return attendanceRecord;
    }

    public static int getIndex(String day) {
        int index = 0;
        while (index < 5 && !(weekDays[index].equals(day))) {
            index++;
        }
        return index;
    }

    public static void sortDays(String[] days, String[] time) {
        for (int i = 0; i < days.length; i++) {
            String temp;
            String temp2;
            int index1 = 0;
            int index2 = 0;
            for (int k = i + 1; k < days.length; k++) {
                index1 = getIndex(days[i]);
                index2 = getIndex(days[k]);
                if (index1 > index2) {
                    temp = days[i];
                    days[i] = days[k];
                    days[k] = temp;
                    temp2 = time[i];
                    time[i] = time[k];
                    time[k] = temp2;
                }
            }
        }
    }

    public static void isExist(String[] days, String day, int[] times, int index) {
        for (int i = 0; i < days.length; i++) {
            if (day.equals(days[i])) {
                System.out.format("%1d:00%3s%3d|", times[i], weekDays[index % 7], index);
            }
        }

    }

    public static int getLengthOf(String[] arr) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                length++;
            }
        }
        return length;
    }

    public static String[] getUpdatedArray(String[] arr) {
        String[] newArr = new String[getLengthOf(arr)];
        for (int i = 0; i < getLengthOf(arr); i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void printFirstLine(int[] times, String[] days) {

        System.out.format("%11s", " ");
        for (int i = 1; i <= 30; i++) {
            int index = i % 7;
            isExist(days, weekDays[index], times, i);
        }
        System.out.println("");
    }

    public static void printAttendance(int[] times, String[] days, String[][] attendanceRecord, String student) {
        int attendanceRecordIndex = 0;
        for (int i = 0; i < attendanceRecord.length; i++) {
            if (attendanceRecord[i][0] == null) {
                break;
            }
            if (attendanceRecord[i][0].equals(student)) {
                attendanceRecordIndex = i;
            }
        }
        for (int i = 1; i <= 30; i++) {
            int index = i % 7;
            int in = -1;
            for (int k = 0; k < days.length; k++) {
                if (weekDays[index].equals(days[k])) {
                    attendanceRecordIndex = 0;
                    for (int j = 0; j < attendanceRecord.length; j++) {
                        if (attendanceRecord[j][0] == null) {
                            break;
                        }
                        if (attendanceRecord[j][0].equals(student)) {
                            if (attendanceRecord[j][0].equals(student) && attendanceRecord[j][1].equals(times[k] + "")
                                    && attendanceRecord[j][2].equals(i + "")) {
                                if (attendanceRecord[j][3].equals("HERE")) {
                                    System.out.format("%10d|", 1);
                                } else if (attendanceRecord[j][3].equals("NOT_HERE")) {
                                    System.out.format("%10d|", -1);
                                }
                                attendanceRecordIndex = 1;
                                break;
                            }
                        }
                    }
                    if (attendanceRecordIndex == 0) {
                        System.out.format("%10s", "|");
                    }
                }
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        students = getStudentsList();
        getDaysAndTime();
        sortDays(weekClasses, times);
        attendanceRecord = getAttendanceRecord();
        printFirstLine(time, weekClasses);

        for (String student : students) {
            System.out.format("%-10s|", student);
            printAttendance(time, weekClasses, attendanceRecord, student);
        }

    }
}
