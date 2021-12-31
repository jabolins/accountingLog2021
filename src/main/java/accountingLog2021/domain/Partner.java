package accountingLog2021.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity(name = "Partner")
@Table(name = "Partner")

public class Partner {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id")
    private long id;

    @Column (name= "PartnerFullName", nullable = false, length = 100)
    private String partnerFullName;

    @Column (name="PartnerShortName", nullable = false, length= 20)
    private String partnerShortName;

    @Enumerated (EnumType.STRING)
    @Column (name="partnerBasicProduct")
    private BasicProductGroup partnerBasicProductGroup;

    @Column (name = "partnerRegNr", length = 20)
    private String partnerRegNr;

}
