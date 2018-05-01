import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2018/4/28 0028.
 */
public class Test {

    public static void main(String[] args) throws Exception {
//        CSVFileUtil csvFileUtil = new CSVFileUtil("C:\\Users\\jack\\Desktop\\exchange_record.csv");
//        String str = csvFileUtil.readLine();
//        System.out.printf(str);
        List<String> list1 = Test.read("C:\\Users\\jack\\Desktop\\exchange_record.csv");
        List<String> list2 = Test.read("C:\\Users\\jack\\Desktop\\exchange_record1.csv");
        list2.add("888888888888888888888888");
        boolean b = list1.removeAll(list2);

        System.out.printf("list"+  list1);
    }

    public static List read(String filePath) {

//        String filePath = "C:\\Users\\jack\\Desktop\\exchange_record.csv";
        List<String> list = new ArrayList<>();
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);

            // 读表头
//            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                // 读一整行
//                System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                System.out.println(csvReader.get(3));
                list.add(csvReader.get(3));

            }
            System.out.printf("list size:" + list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
