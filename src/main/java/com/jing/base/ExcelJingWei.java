package com.jing.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.TimeZone;


public class ExcelJingWei {
    public static void main(String[] args) {
        new ExcelJingWei().excute();
        TimeZone zone = TimeZone.getTimeZone();
    }
     void excute(){

        //excel文件路径
        String excelPath = "D:\\tmp\\wad.xlsx";
        Workbook wb = null;
        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= 2; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        Cell cell = row.getCell(3);
                        if (cell != null) {
                            System.out.println(cell.toString());
                            try {
                                String url = "http://restapi.amap.com/v3/geocode/geo?key=3860639247dc39fefd6df8cf7276a12e&address=";
                                url = url + cell.toString();
                                String result = HttpUtil.sendGet(url);

                                JSONObject jingW = JSON.parseObject(result);
                                JSONArray geocodes = jingW.getJSONArray("geocodes");
                                JSONObject one = geocodes.getJSONObject(0);
                                String location = one.getString("location");
                                String[] st = location.split(",");
                                String jingDu = st[0];
                                String weiDu = st[1];

                                System.out.println("经度：" + jingDu + ", 纬度:" + weiDu);
                                Cell jingCell = row.getCell(7);
                                Cell weiCell = row.getCell(8);
                                jingCell.setCellValue(jingDu);
                                weiCell.setCellValue(weiDu);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (wb != null) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
