package ehospital.dao;

import ehospital.model.Doctor;
import ehospital.model.Receipt;

import java.util.List;

public interface ReceiptDao {

    List<Receipt> getReceiptList() throws Exception;

    void addReceipt(Receipt receipt) throws Exception;

    public void deleteReceipt(Long receiptId)throws Exception;

    public Receipt getReceiptById(Long receiptId) throws Exception;

    public void updateReceipt(Receipt receipt) throws Exception;

}
