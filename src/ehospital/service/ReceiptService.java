/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Receipt;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ReceiptService {

    List<Receipt> getReceiptList() throws Exception;

    void addReceipt(Receipt receipt) throws Exception;

    public void deleteReceipt(Long receiptId)throws Exception;

    public Receipt getReceiptById(Long receiptId)throws Exception;

    public void updateReceipt(Receipt receipt) throws Exception;
}
