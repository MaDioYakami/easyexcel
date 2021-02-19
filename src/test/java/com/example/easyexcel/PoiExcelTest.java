package com.example.easyexcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoiExcelTest {
    @Test
    public void createExcel() {
        List<List<Object>> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add(Arrays.asList("111", "222", "333", "444"));
        }
        //List<String> head = Arrays.asList("表头1", "表头2", "表头3");
        List<List<String>> headlist = new ArrayList<>();
        headlist.add(Arrays.asList("姓名"));
        headlist.add(Arrays.asList("班级"));
        headlist.add(Arrays.asList("笔试成绩"));
        headlist.add(Arrays.asList("机试成绩"));
        PoiExcelTest.createExcelUtil("导出文件抬头", data, headlist);

    }


    public static void createExcelUtil(String headName, List<List<Object>> data, List<List<String>> headlist) {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue(headName);
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        for (int i = 0; i < headlist.size(); i++) {
            List<String> strings = headlist.get(i);
            for (int j = 0; j < strings.size(); j++) {
                row2.createCell(i).setCellValue(strings.get(j));
            }
        }
        //在sheet里创建第三行
        for (int i = 0; i < data.size(); i++) {
            HSSFRow row3 = sheet.createRow(i + 2);
            List<Object> strings = data.get(i);
            for (int j = 0; j < strings.size(); j++) {
                row3.createCell(j).setCellValue((String) strings.get(j));
            }
        }
        //输出Excel文件
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("/Users/madiodio/测试.xlsx");
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
