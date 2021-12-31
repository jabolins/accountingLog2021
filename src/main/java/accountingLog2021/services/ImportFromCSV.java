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
public class ImportFromCSV {
private static final String SWED_BANK_STANDARD= "\"Klienta konts\";\"Ieraksta tips\";\"Datums\";\"Saņēmējs/Maksātājs\"" +
        ";\"Informācija saņēmējam\";\"Summa\";\"Valūta\";\"Debets/Kredīts\";\"Arhīva kods\";\"Maksājuma veids\";" +
        "\"Refernces numurs\";\"Dokumenta numurs\";";

    public ImportFromCSV() {
    }

    public static ArrayList<ImportedTransactions> getTransactions(String filePath){
        ArrayList<ImportedTransactions> result = new ArrayList<>();

        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (checkBank(filePath).equals("SWEDBANK")) {
           result= swedbankCSV(reader);
        }
        else{
            result =null;
        }
        return result;
    }

    private static ArrayList<ImportedTransactions> swedbankCSV(Reader reader) {
        ArrayList<ImportedTransactions> arrayList = new ArrayList<>();
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
                    && !csvRecord.get("Informācija saņēmējam").equals("Beigu atlikums")) {

                ImportedTransactions importedTransactions = new ImportedTransactions();
                importedTransactions.setDate(csvRecord.get("Datums"));
                importedTransactions.setCompany(csvRecord.get("Saņēmējs/Maksātājs"));
                importedTransactions.setDescription(csvRecord.get("Informācija saņēmējam"));
                importedTransactions.setSum(csvRecord.get("Summa"));
                importedTransactions.setBankCash("BANK");
                if (csvRecord.get("Debets/Kredīts").equals("D")) {
                    importedTransactions.setIncomeExpense("EXPENSE");
                } else if (csvRecord.get("Debets/Kredīts").equals("K")) {
                    importedTransactions.setIncomeExpense("INCOME");
                } else {
                    importedTransactions.setIncomeExpense("NONE");
                }

                arrayList.add(importedTransactions);
            }
        }
        return arrayList;
    }

    private static String checkBank(String filePath) {
        try {
            if((Files.readAllLines(Paths.get(filePath)).get(0)).equals(SWED_BANK_STANDARD)){
               return "SWEDBANK";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "bank standard not recognized";
    }
}
