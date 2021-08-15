package com.xrg.sneakerinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xrg.sneakerinventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
