package accountingLog2021.controllers;

import accountingLog2021.domain.Transaction;
import accountingLog2021.models.TransactionFromWeb;
import accountingLog2021.repositories.TransactionRepo;
import accountingLog2021.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    Mapper mapper;

    @GetMapping("registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String transactionAdd(
            @RequestParam String date  //
            , @RequestParam String sum
            , @RequestParam String transactionDocNr
            , @RequestParam String transactionPartner
            , @RequestParam String transactionDescription
            , @RequestParam Integer attitudeForBusiness
            , @RequestParam("bankCash") String bankCash
            , Model model) {
        TransactionFromWeb transactionFromWeb =
                new TransactionFromWeb(date
                        , Double.parseDouble(sum.replace(",", "."))
                        , transactionDocNr
                        , transactionPartner
                        , transactionDescription
                        , bankCash
                        , attitudeForBusiness);
        System.out.println("ievadītais darījums ir ;" + transactionFromWeb); // TODO šis pagaidām pārbaudei

        Transaction transaction = (mapper.mapTransactionFromWeb(transactionFromWeb));

        transactionRepo.save(transaction);

        return "/registration";
    }

}
