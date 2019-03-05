package com.example.demo.service.impl;

import com.example.demo.service.PdfExportService;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author monkey_lwy@163.com
 * @date 2019-03-05 14:09
 * @desc
 */
public class PdfView extends AbstractPdfView {

    private PdfExportService pdfExportService = null;
    /**
     * 创建对象时载入导出服务接口
     * @param pdfExportService
     */
    public PdfView(PdfExportService pdfExportService) {
        this.pdfExportService = pdfExportService;
    }

    /**
     * 调用接口实现导出
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 调用导出服务接口类
        pdfExportService.make(map, document, pdfWriter, request, response);
    }


}
