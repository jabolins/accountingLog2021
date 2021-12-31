package accountingLog2021.ui;

import java.util.Calendar;
import java.util.Date;

public class ImportedTransactions {


        private String date; // TODO vēlāk jāpārtaisa uz date
        private String company;
        private String description;
        private String sum; // TODO vēlāk jāpārtaisa uz Double
        private String incomeExpense; // TODO vēlāk jāpārtaisa uz ENUM
        private String bankCash; // TODO vēlāk jāpārtaisa uz ENUM

        public Calendar getImportedTime() {
                return importedTime;
        }

        public void setImportedTime(Calendar importedTime) {
                this.importedTime = importedTime;
        }

        private Calendar importedTime;

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getCompany() {
                return company;
        }

        public void setCompany(String company) {
                this.company = company;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getSum() {
                return sum;
        }

        public void setSum(String sum) {
                this.sum = sum;
        }

        public String getIncomeExpense() {
                return incomeExpense;
        }

        public void setIncomeExpense(String incomeExpense) {
                this.incomeExpense = incomeExpense;
        }

        public String getBankCash() {
                return bankCash;
        }

        public void setBankCash(String bankCash) {
                this.bankCash = bankCash;
        }

        @Override
        public String toString() {
                return "ImportedTransactions{" +
                        "date='" + date + '\'' +
                        ", company='" + company + '\'' +
                        ", description='" + description + '\'' +
                        ", sum='" + sum + '\'' +
                        ", incomeExpense='" + incomeExpense + '\'' +
                        ", bankCash='" + bankCash + '\'' +
                        ", importedTime=" + importedTime +
                        '}';
        }
}

