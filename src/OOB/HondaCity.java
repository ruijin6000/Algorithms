package OOB;

public class HondaCity extends Car {
    private String mileage;

    public HondaCity(String mile) {

        super(true, "4");
        this.mileage = mile;

    }



    @Override
    public String getMileage() {
        return this.mileage;
    }


    public static void main (String[] args) {

        HondaCity ha = new HondaCity("20");

        System.out.println("test");
    }
}
