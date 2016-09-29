package com.techmap.examples.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 * 这里只处理 xls 格式的 Excel。
 * <p/>
 * Spring 提供的其他相关支持见包 org.springframework.web.servlet.view.document
 * 
 * @author Angrynut
 *
 */
public class XlsView extends AbstractXlsView
{
    
    private static Logger log = Logger.getLogger(XlsView.class);
    
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        log.debug("------> 开始构建 xls 工作簿");
        
        // 你可以通过请求来处理请求参数
        
        CreationHelper createHelper = workbook.getCreationHelper();
        if(workbook.getNumberOfSheets() == 0)
        {
            String safeName = WorkbookUtil.createSafeSheetName("Spring Sheet");
            Sheet sheet = workbook.createSheet(safeName);
            
            Row row = sheet.createRow((short) 0); // 创建一个行，把单元格放到行中。第一行的行号是 0
            
            // 创建一个单元格，并为单元格设置值
            Cell cell = row.createCell(0);
            cell.setCellValue(1);
            
            // 也可以在同一行代码中做到
            row.createCell(1).setCellValue(1.2);
            row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
            row.createCell(3).setCellValue(true);
        }
        
        log.debug("------> 构建 xls 工作簿完成");
    }
    
}
