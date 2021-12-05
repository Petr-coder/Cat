package HM_2_1_2;

public class CheckResult {
    public static void main(String[] args) {
        JuridicalPerson juridicalPerson = new JuridicalPerson();

        IndividualEntrepreneur individualEntrepreneur = new IndividualEntrepreneur();
        individualEntrepreneur.depositSum(2000);
        individualEntrepreneur.depositSum(2000);

        individualEntrepreneur.getAccountInfo();
        individualEntrepreneur.withdrawMoney(970);
        individualEntrepreneur.getAccountInfo();

        System.out.println("____________________________________________________");
        NaturalPerson naturalPerson = new NaturalPerson();

        naturalPerson.depositSum(2000);
        naturalPerson.depositSum(2000);

        naturalPerson.getAccountInfo();
        naturalPerson.withdrawMoney(970);
        naturalPerson.getAccountInfo();

        System.out.println("____________________________________________________");

        juridicalPerson.depositSum(2000);
        juridicalPerson.depositSum(2000);

        juridicalPerson.getAccountInfo();
        juridicalPerson.withdrawMoney(970);
        juridicalPerson.getAccountInfo();
    }
}
