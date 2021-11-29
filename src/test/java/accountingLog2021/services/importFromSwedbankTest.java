package accountingLog2021.services;

import accountingLog2021.ui.ImportedTransactions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class importFromSwedbankTest {
@Test
public void testImport(){

ImportFromSwedbank importFromSwedbank = new ImportFromSwedbank();

for (int i=0; i<importFromSwedbank.getTransactions().size(); i++){
    System.out.println(importFromSwedbank.getTransactions().get(i));
}

}

}