import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserException {
        Scanner enter = new Scanner(System.in);
        while (true) {
            System.out.println("Введите действие: ");
            String stringEnter = enter.nextLine();
            String answer = calc(stringEnter);
            System.out.println(answer);
        }
    }

    public static String calc(String input) throws UserException {
        String[] listEnterChar = input.split(" ");
        if (listEnterChar.length != 3) {
            throw new UserException("Ошибка ввода!");
        }
        String signsEnter = listEnterChar[1];
        String signsList = "+-/*";
        boolean answer = signsList.contains(signsEnter);
        if (!answer) {
            throw new UserException("Ошибка ввода!");
        }
        String romanSymbolList = "IIIVIIIX";
        String txtNumber1 = listEnterChar[0];
        String txtNumber2 = listEnterChar[2];
        boolean answer1 = romanSymbolList.contains(txtNumber1);
        boolean answer2 = romanSymbolList.contains(txtNumber2);

        if (answer1 && answer2) {
            ConverterRomToArab numArab1 = ConverterRomToArab.valueOf(txtNumber1);
            ConverterRomToArab numArab2 = ConverterRomToArab.valueOf(txtNumber2);

            int resultArabic = 0;
            String resultRoman = "";
            int number1 = numArab1.getNumber();
            int number2 = numArab2.getNumber();
            switch (signsEnter) {
                case "+" -> resultArabic = number1 + number2;
                case "-" -> resultArabic = number1 - number2;
                case "*" -> resultArabic = number1 * number2;
                case "/" -> resultArabic = number1 / number2;
            }
            if (resultArabic <= 0) {
                throw new UserException("В римской системе нет отрицательных чисел и ноля!");
            }
            if (resultArabic > 10 && resultArabic % 10 != 0) {
                int tens = resultArabic - resultArabic % 10;
                int units = resultArabic % 10;
                String _tens = "_" + tens;
                String _units = "_" + units;

                ConverterArabToRom tensRomanObj = ConverterArabToRom.valueOf(_tens);
                ConverterArabToRom unitsRomanObj = ConverterArabToRom.valueOf(_units);
                String tensRoman = tensRomanObj.getNumber();
                String unitsRoman = unitsRomanObj.getNumber();
                resultRoman = tensRoman + unitsRoman;
            }
            if (resultArabic % 10 == 0) {
                String _resultArabic = "_" + resultArabic;
                ConverterArabToRom resultRomanObj = ConverterArabToRom.valueOf(_resultArabic);
                resultRoman = resultRomanObj.getNumber();
            }
            if (resultArabic > 0 && resultArabic < 10) {
                String __a = "_" + resultArabic;
                ConverterArabToRom num__1 = ConverterArabToRom.valueOf(__a);
                String num__1_arab = num__1.getNumber();
                resultRoman = num__1_arab;
            }
            //System.out.println(resultRoman);
            return resultRoman;
        } else {
            try {
                int number1 = Integer.parseInt(listEnterChar[0]);
                int number2 = Integer.parseInt(listEnterChar[2]);
                if (number1 == 0 || number1 > 10 || number2 == 0 || number2 > 10) {
                    throw new UserException("Ошибка ввода! Диапазон чисел должен быть от 1 до 10!");
                }
                int resultArabic = 0;
                switch (signsEnter) {
                    case "+" -> resultArabic = number1 + number2;
                    case "-" -> resultArabic = number1 - number2;
                    case "*" -> resultArabic = number1 * number2;
                    case "/" -> resultArabic = number1 / number2;
                }
                String resultArabicStr = Integer.toString(resultArabic);
                return resultArabicStr;
            } catch (NumberFormatException e) {
                throw new UserException("Ошибка ввода");
            }
        }
    }
}

