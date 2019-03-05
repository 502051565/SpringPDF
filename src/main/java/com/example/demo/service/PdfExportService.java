package com.example.demo.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
/**
 * @author monkey_lwy@163.com
 * @date 2019-03-05 14:07
 * @desc
 */
public interface PdfExportService {

    /**
     * 导出的方法
     * @param model 数据模型
     * @param document 代表一个pdf文档
     * @param writer pdf写入器
     * @param request HttpServletRequest请求对象
     * @param response HttpServletResponse响应对象
     */
    public void make(Map<String, Object> model, Document document, PdfWriter writer,
                     HttpServletRequest request, HttpServletResponse response);

}
