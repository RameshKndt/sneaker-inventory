package com.xrg.sneakerinventory.helper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.xrg.sneakerinventory.model.Inventory;

public class InventoryExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Brand", "Model", "NickName","Size", "Type", "Store Id","State","Color" };
  static String SHEET = "Inventory";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  
  public static List<Inventory> excelToInventory(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<Inventory> inventoryList = new ArrayList<Inventory>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        Inventory.InventoryBuilder inventoryBuilder = Inventory.builder();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {

          case 0:
        	  inventoryBuilder.setBrand(currentCell.getStringCellValue());
            break;

          case 1:
        	  inventoryBuilder.setModel(currentCell.getStringCellValue());
            break;

          case 2:
        	  inventoryBuilder.setNickname(currentCell.getStringCellValue());
            break;

          default:
            break;
          }

          cellIdx++;
        }

        inventoryList.add(inventoryBuilder.build());
      }

      workbook.close();

      return inventoryList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
