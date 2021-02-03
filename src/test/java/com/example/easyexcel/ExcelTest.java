package com.example.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.example.easyexcel.pojo.ComplexHeadData;
import com.example.easyexcel.pojo.DataDemo;
import com.example.easyexcel.pojo.MultiLineHeadExcelModel;
import com.example.easyexcel.pojo.TableHeaderExcelProperty;
import com.example.easyexcel.util.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class ExcelTest {

    /**
     * 读取少于1000行的excle
     */
    @Test
    public void readLessThan1000Row() {
        String filePath = "/Users/madiodio/测试.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
        objects.forEach(System.out::println);
    }

    /**
     * 读取少于1000行的excle，可以指定sheet和从几行读起
     */
    @Test
    public void readLessThan1000RowBySheet() {
        String filePath = "/Users/madiodio/测试.xlsx";
        Sheet sheet = new Sheet(1, 1);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath, sheet);
        objects.forEach(System.out::println);
    }

    /**
     * 读取大于1000行的excle
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @Test
    public void readMoreThan1000Row() {
        String filePath = "/Users/madiodio/测试.xlsx";
        Sheet sheet = new Sheet(1, 1);
        List<Object> objects = ExcelUtil.readMoreThan1000Row(filePath, sheet);
        objects.forEach(System.out::println);
    }


    /**
     * 生成excle
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @Test
    public void writeBySimple() {
        String filePath = "/Users/madio/测试.xlsx";
        List<List<Object>> data = new ArrayList<>();
        for(int i=0;i<100000;i++){
            data.add(Arrays.asList("111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444","111", "222", "333","111", "222", "333","111", "222", "333","444"));
        }
        //List<String> head = Arrays.asList("表头1", "表头2", "表头3");
        List<List<String>> headlist = new ArrayList<>();
        headlist.add(Arrays.asList("表头1"));
        headlist.add(Arrays.asList("表头2"));
        headlist.add(Arrays.asList("表头3"));

        //ExcelUtil.writeBySimple(filePath, data, head);
        EasyExcel.write(filePath).sheet("sheet").head(headlist).doWrite(data);
    }

    @Test
    public void writeBySimple2() {
        String filePath = "/Users/madio/测试.xlsx";
        List<List<Object>> data = new ArrayList<>();
        //EasyExcel.write(filePath, DataDemo.class).sheet("sheet").doWrite(data);
        //EasyExcel.write(filePath, ComplexHeadData.class).sheet("sheet").doWrite(data);
        EasyExcel.write(filePath, MultiLineHeadExcelModel.class).sheet("sheet").doWrite(data);
    }




    /**
     * 生成excle, 带用模型
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @Test
    public void writeWithTemplate() {
        String filePath = "/Users/madiodio/测试2.xlsx";
        ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("cmj" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("清华大学" + i);
            data.add(tableHeaderExcelProperty);
        }
        ExcelUtil.writeWithTemplate(filePath, data);
    }


    /**
     * 生成excle, 带用模型,带多个sheet
     */
    @Test
    public void writeWithMultipleSheel() {
        ArrayList<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();
        for (int j = 1; j < 4; j++) {
            ArrayList<TableHeaderExcelProperty> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
                tableHeaderExcelProperty.setName("cmj" + i);
                tableHeaderExcelProperty.setAge(22 + i);
                tableHeaderExcelProperty.setSchool("清华大学" + i);
                list.add(tableHeaderExcelProperty);
            }

            Sheet sheet = new Sheet(j, 0);
            sheet.setSheetName("sheet" + j);

            ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
            multipleSheelPropety.setData(list);
            multipleSheelPropety.setSheet(sheet);

            list1.add(multipleSheelPropety);

        }

        ExcelUtil.writeWithMultipleSheel("/home/chenmingjian/Downloads/aaa.xlsx", list1);

    }


    /*******************匿名内部类，实际开发中该对象要提取出去**********************/


}
