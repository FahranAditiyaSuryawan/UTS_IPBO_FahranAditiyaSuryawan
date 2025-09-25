package digitalzoo.com;

/**
 * Animal adalah superclass atau kelas dasar untuk semua hewan.
 * Class ini berisi properti dan perilaku umum yang dimiliki oleh semua hewan.
 */
public class Animal {
    // Properti dasar yang dilindungi (private)
    private String name;
    private int age;

    /**
     * Constructor untuk menginisialisasi nama dan umur hewan.
     * @param name Nama dari hewan.
     * @param age Umur dari hewan.
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter dan Setter untuk setiap properti
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Metode untuk menghasilkan suara generik hewan.
     * @return String yang merepresentasikan suara hewan.
     */
    public String makeSound() {
        return "Hewan ini mengeluarkan suara.";
    }

    /**
     * Metode untuk mendapatkan informasi dasar hewan.
     * @return String yang berisi nama dan umur hewan.
     */
    public String getInfo() {
        return "Nama: " + name + ", Umur: " + age;
    }
}