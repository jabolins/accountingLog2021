package accountingLog2021.services;

import accountingLog2021.ui.ImportedTransactions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class importFromCSVTest {
    @Test
    public void testImport() {

//ImportFromCSV importFromCSV = new ImportFromCSV();
        String filePath = "D:\\Google_disks\\Apmacibas\\Programmesana\\Java\\Projekti\\Uzskaites_zurnals\\Swedbank.csv";
        if (ImportFromCSV.getTransactions(filePath)!=null) {

            ArrayList<ImportedTransactions> importedTransactionsCSV = new
                    ArrayList<>(ImportFromCSV.getTransactions(filePath));

            for (int i = 0; i < importedTransactionsCSV.size(); i++) {
                System.out.println(importedTransactionsCSV.get(i));
            }
        }
        else
            System.out.println("arrayList is empty");
    }

}