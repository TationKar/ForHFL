import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/tationkar/Documents/FTP/Samples/KarimovTimurDataSort/res/text");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert fileInputStream != null;
        Reader ir = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(ir);
        String string;
        ArrayList<String> cleanString = new ArrayList<>();
        try {
            int counter = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine())!=null){
                Pattern p = Pattern.compile("<tab>");
                Matcher m = p.matcher(string);
                while(m.find()) {
//                    if (counter==0){
//                        String firstNumber = string.substring(0, string.indexOf("<"));
//                        if (firstNumber.matches(".+\\d"))
//                        System.out.println("Первые символы это ID = " + firstNumber);
//                    }
                    //ТУТ ПРОВЕРКА ID НА ЧИСЛО
                    counter++;
                }
                stringBuilder.append(string);
                if (counter==7)  {
                    counter = 0;
                    cleanString.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("/Users/tationkar/Documents/FTP/Samples/KarimovTimurDataSort/res/t.tsv", false)) {
            for (String a : cleanString) {
                fileWriter.append(a).append('\n');
            }
        }
    }
}