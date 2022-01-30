/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.ReceiptDao;
import ehospital.model.Receipt;
import ehospital.service.ReceiptService;
import java.util.List;

/**
 *
 * @author hp
 */
public class ReceiptServiceImpl implements ReceiptService {

    private ReceiptDao receiptDao;

    public ReceiptServiceImpl(ReceiptDao receiptDao) {
        this.receiptDao = receiptDao;
    }

    @Override
    public List<Receipt> getReceiptList() throws Exception {
        return receiptDao.getReceiptList();
    }

    @Override
    public void addReceipt(Receipt receipt) throws Exception {
        receiptDao.addReceipt(receipt);
    }

    @Override
    public void deleteReceipt(Long receiptId) throws Exception {
        receiptDao.deleteReceipt(receiptId);
    }

    @Override
    public Receipt getReceiptById(Long receiptId) throws Exception {
        return receiptDao.getReceiptById(receiptId);
    }

    @Override
    public void updateReceipt(Receipt receipt)throws Exception {
        receiptDao.updateReceipt(receipt);
    }

}
