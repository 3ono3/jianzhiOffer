import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.print.attribute.standard.Finishings;
import java.time.Year;
import java.util.*;

/**
 * 转换数据结构
 * @author GuoJingyuan
 * @date 2019/10/21
 */
public class QuarterTest {
    private static Map<String, Object> originalMap = new HashMap<>();

    public static void main(String[] args) {
        QuarterTest qt = new QuarterTest();
        qt.initData();
        List<Map<String, Object>> result = qt.mapChange();
        System.out.println(111);
    }
    private List<Map<String, Object>> mapChange() {
        int startYear = (int) originalMap.get("startYear");
        int startQuarter = (int) originalMap.get("startQuarter");
        int endYear = (int) originalMap.get("endYear");
        int endQuarter = (int) originalMap.get("endQuarter");

        List<Map<String, String>> dataList = (List<Map<String, String>>) originalMap.get("dataList");

        //[{name:印花税,value:[{year:2019,q1:100,q2:100 ...},...]}，...]
        List<Map<String, Object>> resultMap = new LinkedList<>();


        for (int i = 0; i < dataList.size(); i++) {
            Map<String, String> dataItem = dataList.get(i);
            //{name:印花税,value:[{year:2019,q1:100,q2:100 ...},...]}
            Map<String, Object> resultTermsMap = new HashMap<>();
            String keyName = dataItem.get("name");
            resultTermsMap.put("kye", keyName);
            //[{year:2019,q1:100,q2:100 ...},{year:2020,q1:100,q2:100 ...},...]
            List<Map<String, String>> yearMapList = yearMapList(dataItem, startYear, startQuarter, endYear);
            resultTermsMap.put("value", yearMapList);
            resultMap.add(resultTermsMap);
        }
        return resultMap;
    }
    private List<Map<String, String>> yearMapList(Map<String, String> dataItem, int startYear, int startQuarter, int endYear) {
        final int quarterNum = 4;
        final int deviate = quarterNum - startQuarter + 1;
        final int cyclesNum = endYear - startYear;
        List<Map<String, String>> yearMapList = new LinkedList<>();
        //第一年
        Map<String, String> firstYear = new HashMap<>();
        firstYear.put("year", String.valueOf(startYear));
        for (int i = startQuarter,j=1; i <= 4; i++,j++) {
            String qValue = dataItem.get("item"+j);
            firstYear.put("q" + i, qValue);
        }
        yearMapList.add(firstYear);
        //后面几年
        for (int c = 0; c < cyclesNum; c++) {
            Map<String, String> itemYearMap = new HashMap<>();
            itemYearMap.put("year", String.valueOf(startYear + 1 + c));
            for (int i = 1; i <= quarterNum; i++ ) {
                int itemValue = quarterNum * c + deviate + i;
                String qValue = dataItem.get("item"+itemValue);
                itemYearMap.put("q"+ i, qValue);
            }
            yearMapList.add(itemYearMap);
        }

        return yearMapList;
    }

    private void initData() {
        List<Map<String, String>> dataList = new ArrayList<>();

        Map<String, String> dataItem1 = getMapItemMap();
        dataItem1.put("name", "印花税");
        dataList.add(dataItem1);

        Map<String, String> dataItem2 = getMapItemMap();
        dataItem2.put("name", "利息");
        dataList.add(dataItem2);

        Map<String, String> dataItem3 = getMapItemMap();
        dataItem3.put("name", "贷款");
        dataList.add(dataItem3);

        Map<String, String> dataItem4 = getMapItemMap();
        dataItem4.put("name", "过户费");
        dataList.add(dataItem4);

        originalMap.put("dataList", dataList);
        originalMap.put("startYear", 2017);
        originalMap.put("startQuarter", 3);
        originalMap.put("endYear", 2019);
        originalMap.put("endQuarter", 4);

    }
    private Map<String, String> getMapItemMap() {
        Map<String, String> mapItem = new HashMap<>();
        mapItem.put("item1", "0.1111");
        mapItem.put("item2", "0.1112");
        mapItem.put("item3", "0.1113");
        mapItem.put("item4", "0.1114");
        mapItem.put("item5", "0.1115");
        mapItem.put("item6", "0.1116");
        mapItem.put("item7", "0.1117");
        mapItem.put("item8", "0.1118");
        mapItem.put("item9", "0.1119");
        return mapItem;
    }

//        mapItem.put("item1", "0.1111");3
//        mapItem.put("item2", "0.1112");4
//        mapItem.put("item3", "0.1113");4*0 + 2 + 1
//        mapItem.put("item4", "0.1114");4*0 + 2 + 2
//        mapItem.put("item5", "0.1115");4*0 + 2 + 3
//        mapItem.put("item6", "0.1116");4*0 + 2 + 4
//        mapItem.put("item7", "0.1117");4*1 + 2 + 1
}
