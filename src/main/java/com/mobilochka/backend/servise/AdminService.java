package com.mobilochka.backend.servise;

import com.mobilochka.backend.model.product.Product;
import com.mobilochka.backend.repository.CatalogRepository;
import com.mobilochka.backend.repository.GroupRepository;
import com.mobilochka.backend.repository.ManufacturRepository;
import com.mobilochka.backend.repository.ProductRepository;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@Service
public class AdminService {

    private final CatalogRepository catalogRepository;
    private final GroupRepository groupRepository;
    private final ProductRepository productRepository;
    private final ManufacturRepository manufacturRepository;

    public AdminService(CatalogRepository catalogRepository, GroupRepository groupRepository, ProductRepository productRepository, ManufacturRepository manufacturRepository) {
        this.catalogRepository = catalogRepository;
        this.groupRepository = groupRepository;
        this.productRepository = productRepository;
        this.manufacturRepository = manufacturRepository;
    }

    public void loadByExel(String adress) throws IOException {
        FileInputStream file = new FileInputStream(new File(adress));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        for (int i = 8; i < lastRow; i++) {
            catalogRepository.saveByName(sheet.getRow(i).getCell(0).toString());
            groupRepository.saveByName(sheet.getRow(i).getCell(1).toString());
            manufacturRepository.saveByName(sheet.getRow(i).getCell(2).toString());
            sheet.getRow(i).getCell(11).setCellType(CellType.STRING);
            sheet.getRow(i).getCell(4).setCellType(CellType.STRING);
            Product product = new Product(
                    groupRepository.findByName(sheet.getRow(i).getCell(1).toString()),
                    catalogRepository.findByName(sheet.getRow(i).getCell(0).toString()),
                    manufacturRepository.findByName(sheet.getRow(i).getCell(2).toString()),
                    sheet.getRow(i).getCell(3).toString(),
                    sheet.getRow(i).getCell(4).toString(),
                    (int) sheet.getRow(i).getCell(5).getNumericCellValue(),
                    (int) sheet.getRow(i).getCell(6).getNumericCellValue(),
                    sheet.getRow(i).getCell(9).toString(),
                    Long.parseLong(sheet.getRow(i).getCell(11).toString()),
                    sheet.getRow(i).getCell(12).toString()

            );
            productRepository.save(product);
        }

    }

}


