package accountingLog2021.services;

import accountingLog2021.ui.ImportedTransactions;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

@Service
public class ImportFromSwedbank {

    public ImportFromSwedbank() {
    }

    ArrayList<ImportedTransactions> importedTransactions;

    private static final String SAMPLE_CSV_FILE_PATH = "D:\\Google_disks\\Apmacibas\\Programmesana\\Java\\Projekti\\Uzskaites_zurnals\\Swedbank.csv";


    public ArrayList<ImportedTransactions> getTransactions(){
        ArrayList<ImportedTransactions> result = new ArrayList<>();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVParser csvParser = null;
        try {
            csvParser = new CSVParser(reader, CSVFormat.EXCEL.withDelimiter(';')
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (CSVRecord csvRecord : csvParser) {

            if (!csvRecord.get("Informācija saņēmējam").equals("Sākuma atlikums")
                    && !csvRecord.get("Informācija saņēmējam").equals("Apgrozījums")
                    && !csvRecord.get("Informācija saņēmējam").equals("Beigu atlikums"))
            {
                ImportedTransactions importedTransactions = new ImportedTransactions();
                importedTransactions.setDate(csvRecord.get("Datums"));
                importedTransactions.setCompany(csvRecord.get("Saņēmējs/Maksātājs"));
                importedTransactions.setDescription(csvRecord.get("Informācija saņēmējam"));
                importedTransactions.setSum(csvRecord.get("Summa"));

                if (csvRecord.get("Debets/Kredīts").equals("D")) {
                    importedTransactions.setIncomeExpense("EXPENSE");
                } else if (csvRecord.get("Debets/Kredīts").equals("K")) {
                    importedTransactions.setIncomeExpense("INCOME");
                } else {
                    importedTransactions.setIncomeExpense("NONE");
                }

                importedTransactions.setBankCash("BANK");
                result.add(importedTransactions);
            }
//            // Accessing values by Header names
//            String date = csvRecord.get("Datums");
//            String company = csvRecord.get("Saņēmējs/Maksātājs");
//            String description = csvRecord.get("Informācija saņēmējam");
//            String sum = csvRecord.get("Summa");
//            String incomeExpense = csvRecord.get("Debets/Kredīts");
//
//            System.out.println("Record No - " + csvRecord.getRecordNumber());
//            System.out.println("---------------");
//            System.out.println("Date: " + date);
//            System.out.println("Company : " + company);
//            System.out.println("Description : " + description);
//            System.out.println("Sum : " + sum);
//            System.out.println("IncomeExpense: " + incomeExpense);
//            System.out.println("---------------\n\n");

        }

        return result;
    }
}
