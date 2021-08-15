package com.xrg.sneakerinventory.service;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.xrg.sneakerinventory.helper.InventoryExcelHelper;
import com.xrg.sneakerinventory.model.Inventory;
import com.xrg.sneakerinventory.repository.InventoryRepository;


@Service
public class InventoryExcelService {
  @Autowired
  InventoryRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Inventory> inventory = InventoryExcelHelper.excelToInventory(file.getInputStream());
      repository.saveAll(inventory);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

 

  public List<Inventory> getAllInventory() {
    return repository.findAll();
  }
}
