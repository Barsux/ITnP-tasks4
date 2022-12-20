import java.util.Arrays;

public class Tasks4 {
    public static void main(String[] args){
        System.out.println("Задача 1");
        System.out.println(bessie(10, 7, "Hello my name is Bessie and this is my essay"));
        System.out.println("\nЗадача2");
        System.out.println("split(\"()()()\") -> " + Arrays.toString(split("()()()")));
        System.out.println("split(\"((()))\") -> " + Arrays.toString(split("((()))")));
        System.out.println("split(\"((()))(())()()(()())\") -> " + Arrays.toString(split("((()))(())()()(()())")));
        System.out.println("split(\"((())())(()(()()))\") -> " + Arrays.toString(split("((())())(()(()()))")));
        System.out.println("\nЗадача3");
        System.out.println("toCamelCase(\"hello_edabit\") -> " + toCamelCase("hello_edabit"));
        System.out.println("toSnakeCase(\"helloEdabit\") -> " + toSnakeCase("helloEdabit"));
        System.out.println("toCamelCase(\"is_modal_open\") -> " + toCamelCase("is_modal_open"));
        System.out.println("toSnakeCase(\"getColor\") -> " + toSnakeCase("getColor"));
        System.out.println("\nЗадача4");
        System.out.println("overTime([9, 17, 30, 1.5]) -> " + overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println("overTime([16, 18, 30, 1.8]) -> " + overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println("overTime([13.25, 15, 30, 1.5]) -> " + overTime(new double[]{13.25, 15, 30, 1.5}));
        System.out.println("\nЗадача5");
        System.out.println("BMI(\"205 pounds\", \"73 inches\") -> " + BMI("205 pounds", "73 inches"));
        System.out.println("BMI(\"55 kilos\", \"1.65 meters\") -> " + BMI("55 kilos", "1.65 meters"));
        System.out.println("BMI(\"154 pounds\", \"2 meters\") -> " + BMI("154 pounds", "2 meters"));
        System.out.println("\nЗадача6");
        System.out.println("bugger(39) -> " + bugger(39));
        System.out.println("bugger(999) -> " + bugger(999));
        System.out.println("bugger(4) -> " + bugger(4));
        System.out.println("\nЗадача7");
        System.out.println("toStarShorthand(\"abbccc\") -> " + toStarShorthand("abbccc"));
        System.out.println("toStarShorthand(\"77777geff\") -> " + toStarShorthand("77777geff"));
        System.out.println("toStarShorthand(\"abc\") -> " + toStarShorthand("abc"));
        System.out.println("toStarShorthand(\"\") -> " + toStarShorthand(""));
        System.out.println("\nЗадача8");
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and ham.\") -> " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") -> " + doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println("doesRhyme(\"You are off to the races\", \"a splendid day.\") -> " + doesRhyme("You are off to the races", "a splendid day."));
        System.out.println("doesRhyme(\"and frequently do?\", \"you gotta move.\") -> " + doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("\nЗадача9");
        System.out.println("trouble(451999277, 41177722899) -> " + trouble(451999277, 41177722899L));
        System.out.println("trouble(1222345, 12345) -> " + trouble(1222345, 12345));
        System.out.println("trouble(666789, 12345667) -> " + trouble(666789, 12345667));
        System.out.println("trouble(33789, 12345337) -> " + trouble(33789, 12345337));
        System.out.println("\nЗадача10");
        System.out.println("countUniqueBooks(\"AZYWABBCATTTA\", 'A') -> " + countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println("countUniqueBooks(\"$AA$BBCATT$C$$B$\", '$') -> " + countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println("countUniqueBooks(\"ZZABCDEF\", 'Z') -> " + countUniqueBooks("ZZABCDEF", 'Z'));
    }

    /** Функция итерирует по всем словам и в зависимости от суммы результирующей строки и следующего слова определяет добавить ли слово в рез. строку или вывести и очистить её*/
    public static String bessie(int n, int k, String essay){
        String[] words = essay.split(" ");
        StringBuilder result = new StringBuilder();
        int length = words[0].length();
        result.append(words[0]);
        for(int i = 1; i < n; i++){
            if(words[i].length() + length <= k) {
                result.append(" " + words[i]);
                length += words[i].length();
            } else {
                result.append('\n');
                length = words[i].length();
                result.append(words[i]);
            }
        }
        return result.toString();
    }

    /** Функция считает кол-во кластеров, а затем повторно считывает их в массив посчитанной длины */
    public static String[] split(String str){
        char l = '(';
        char r = ')';
        StringBuilder temp = new StringBuilder();
        String[] answer = new String[str.length()];
        int counter = 0;
        int arrPtr = 0;
        for(char lit: str.toCharArray()){
            if(lit == l){
                counter++;
            }
            else if(lit == r)counter--;
            temp.append(lit);
            if(counter == 0){
                answer[arrPtr] = temp.toString();
                temp = new StringBuilder();
                arrPtr++;
            }
        }
        return Arrays.copyOf(answer, arrPtr);
    }

    /** Функция разбивает строку по '_' а затем собирает снова капитализируя каждое слово */
    public static String toCamelCase(String str){
        String[] words = str.split("_");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(i == 0)sb.append(words[i].toLowerCase());
            else sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
        }
        return sb.toString();
    }

    /** Функция разбивает строку по заглавным буквам и собирает снова с '_' в нижнем регистре */
    public static String toSnakeCase(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                sb.append("_" + str.substring(i, i + 1).toLowerCase());
            } else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /** Функция считает кол-во часов обычной работы и кол-во часов сверхурочных, и по ним высчитывает итоговую стоимость */
    public static String overTime(double[] arr){
        double start = arr[0];
        double end = arr[1];
        double payment = arr[2];
        double bonus = arr[3];
        double summa = 0;
        if(start > 17){
            summa += (end - start) * payment * bonus;
        } else if(end > 17){
            summa += (17 - start) * payment;
            summa += (end - 17) * payment * bonus;
        } else {
            summa += (end - start) * payment;
        }
        return "$" + summa;
    }

    /** Функция считывает вес и рост, и в зависимости от значений и входных величин возвращает BMI*/
    public static String BMI(String weight, String height) {
        double w = Double.parseDouble(weight.split(" ")[0]);
        double h = Double.parseDouble(height.split(" ")[0]);
        String weightType = weight.split(" ")[1].toLowerCase();
        String heightType = height.split(" ")[1].toLowerCase();
        if(weightType.equals("pounds"))w *= 0.453592;
        if(heightType.equals("inches"))h *= 0.0254;
        double bmi = w / (h * h);
        if(bmi <= 18.5)return String.format("%.1f", bmi) + " Underweight";
        else if(bmi <= 25)return String.format("%.1f", bmi) + " Normal weight";
        else return String.format("%.1f", bmi) + " Overweight";
    }

    /** Функция возвращает кол-во перемножений цифр числа */
    public static int bugger(int x){
        int counter = 0;
        int mull = 1;
        while (x > 9){
            while(x > 0){
                mull *= (x % 10);
                x /= 10;
            }
            x = mull;
            mull = 1;
            counter++;
        }
        return counter;
    }

    /** Подсчитывает кол-во повторений символов и выводит в виде AAAsdg -> A*3sdg */
    public static String toStarShorthand(String s) {
        if (s.isEmpty()) {
            return "";
        }
        char x = s.charAt(0);
        int count = 1;
        s += " ";
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (x != s.charAt(i)) {
                if (count == 1) {
                    strBuilder.append(x);
                }
                else {
                    strBuilder.append(x).append("*").append(count);
                }
                count = 1;
                x = s.charAt(i);
            }
            else {
                count ++;
            }
        }
        return strBuilder.toString();
    }

    /** Проверяет рифмуются ли слова сравнивая гласные последних слов */
    public static boolean doesRhyme(String word1, String word2){
        String vowels = "aeiou";
        StringBuilder vW1 = new StringBuilder();
        StringBuilder vW2 = new StringBuilder();
        String words[] = word1.split(" ");
        for(char lit: words[words.length - 1].toLowerCase().toCharArray()){
            if(vowels.contains(String.valueOf(lit))){
                vW1.append(lit);
            }
        }
        words = word2.split(" ");
        for(char lit: words[words.length - 1].toLowerCase().toCharArray()){
            if(vowels.contains(String.valueOf(lit))){
                vW2.append(lit);
            }
        }
        return vW1.toString().equals(vW2.toString());
    }

    /** Фукнция ищет символ, повторяющийся три раза и затем ищет его во втором слове, где он должен повторятся дважды */
    public static boolean trouble(long num1, long num2){
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        for(int i = 0; i < str1.length() - 2; i++){
            if(str1.charAt(i) == str1.charAt(i + 1) && str1.charAt(i) == str1.charAt(i + 2)){
                for(int j = 0; j < str2.length() - 1; j++){
                    if(str2.charAt(j) == str2.charAt(j + 1) && str2.charAt(j) == str1.charAt(i)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** Функция считает кол-во уникальных символов в подстроках строки, которые начинаются и заканчиваются с char c */
    public static int countUniqueBooks(String str, char c){
        String[] words = str.split("[" + c + "]");
        StringBuilder unique = new StringBuilder();
        for(int i = 1; i < words.length; i += 2){
            for(char lit: words[i].toCharArray()){
                if(unique.indexOf(lit + "") == -1)unique.append(lit);
            }
        }

        return unique.length();
    }
}
