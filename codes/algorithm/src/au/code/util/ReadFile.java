package au.code.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project algorithm
 * @Description: ReadFile
 * @Author
 * @Explain
 * @Date 2021-04-17 22:39
 */
public class ReadFile {

    public static void main(String[] args) {
        ArrayList<DateInfo> dateInfos = readFileContent();

        System.out.println(dateInfos.get(0));
    }

    public static ArrayList<DateInfo> readFileContent() {

        File file = new File("C:\\Users\\Administrator.WIN-IHVBI18K8J9\\Desktop\\algorithm\\codes\\algorithm\\data.txt");
        BufferedReader reader = null;
        ArrayList<DateInfo> dataList = new ArrayList<>();

        try {

            reader = new BufferedReader(new FileReader(file));
            String tempStr;

            while ((tempStr = reader.readLine()) != null) {

                String[] lineData = tempStr.split(" ");
                DateInfo dateInfo = new DateInfo();
                dateInfo.setNumber(Integer.parseInt(lineData[0]));
                dateInfo.setNickname(lineData[1]);
                dateInfo.setMoney(Double.parseDouble(lineData[2]));
                dataList.add(dateInfo);



            }

            reader.close();
            return dataList;

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (reader != null) {

                try {

                    reader.close();

                } catch (IOException e1) {

                    e1.printStackTrace();

                }

            }

        }

        return dataList;

    }

}

class DateInfo {



    private int number;

    private String nickname;

    private Double money;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public DateInfo() {
    }

    public DateInfo(int number) {
        this.number = number;
    }

    public DateInfo(int number, String nickname) {
        this.number = number;
        this.nickname = nickname;
    }

    public DateInfo(int number, String nickname, Double money) {
        this.number = number;
        this.nickname = nickname;
        this.money = money;
    }

    @Override
    public String toString() {
        return "DateInfo{" +
                "number=" + number +
                ", nickname='" + nickname + '\'' +
                ", money=" + money +
                '}';
    }
}
