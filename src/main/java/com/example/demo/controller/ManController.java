package com.example.demo.controller;

import com.example.demo.entity.Man;
import com.example.demo.service.PdfExportService;
import com.example.demo.service.impl.PdfView;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author monkey_lwy@163.com
 * @date 2019-03-05 14:15
 * @desc
 */
@Controller
@RequestMapping("/man")
public class ManController {


    /**
     * 导出接口
     * @return
     *
     * https://blog.csdn.net/a_helloword/article/details/83046821
     * http://www.cnblogs.com/scuury/p/10093287.html
     */
    @GetMapping("/export/pdf")
    public ModelAndView exportPdf() {
        List<Man> manList = new ArrayList<>();
        Man man = new Man();
        man.setId(1);
        man.setAge("20");
        man.setName("20张");//todo 中文不显示？
        manList.add(man);
        // 定义pdf视图
        View view = new PdfView(exportService());
        ModelAndView mv = new ModelAndView();
        // 设置视图
        mv.setView(view);
        // 加入数据模型
        mv.addObject("manList", manList);
        return mv;
    }


    /**
     * 导出pdf自定义，每个控制器可以实现自己的导出逻辑
     * @return
     */
    @SuppressWarnings("unchecked")
    public PdfExportService exportService() {
        // 使用Lambda表达式
        return(model, document, writer, request, response)-> {
            try {
                response.setCharacterEncoding("UTF-8");
                // A4纸张
                document.setPageSize(PageSize.A4);
                // 标题
                document.addTitle("用户信息");
                // 换行
                document.add(new Chunk("\n"));
                // 表格，3列
                PdfPTable table = new PdfPTable(3);
                // 单元格
                PdfPCell cell = null;
                // 字体，定义为蓝色加粗
                Font f8 = new Font();
                f8.setColor(Color.BLUE);
                f8.setStyle(Font.BOLD);
                // 标题
                cell = new PdfPCell(new Paragraph("id", f8));
                // 居中对齐
                cell.setHorizontalAlignment(1);
                // 将单元格加入表格
                table.addCell(cell);

                // 标题
                cell = new PdfPCell(new Paragraph("age", f8));
                // 居中对齐
                cell.setHorizontalAlignment(1);
                // 将单元格加入表格
                table.addCell(cell);

                // 标题
                cell = new PdfPCell(new Paragraph("name", f8));
                // 居中对齐
                cell.setHorizontalAlignment(1);
                // 将单元格加入表格
                table.addCell(cell);

                // 获取数据模型中的manList
                List<Man> manList = (List<Man>)model.get("manList");
                for(Man man:manList) {
                    document.add(new Chunk("\n"));


                    cell = new PdfPCell(new Paragraph(man.getId() + ""));
                    // 居中对齐
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);


                    cell = new PdfPCell(new Paragraph(man.getAge() + ""));
                    // 居中对齐
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);


                    cell = new PdfPCell(new Paragraph(man.getName()));
                    // 居中对齐
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                }
                // 文档中加入表格
                document.add(table);
            } catch(DocumentException e) {
                e.printStackTrace();
            }
        };
    }
}
