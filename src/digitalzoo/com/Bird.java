package digitalzoo.com;

/**
 * Bird adalah subclass yang mewarisi (extends) dari Animal.
 * Class ini merepresentasikan hewan burung.
 */
public class Bird extends Animal {
    // Properti spesifik aktivitas Burung
    private boolean canFly;

    /**
     * Constructor untuk Bird.
     * Memanggil constructor parent (Animal) dan menginisialisasi canFly.
     * @param name Nama burung.
     * @param age Umur burung.
     * @param canFly Apakah burung bisa terbang.
     */
    public Bird(String name, int age, boolean canFly) {
        super(name, age); // Memanggil constructor dari class Animal
        this.canFly = canFly;
    }

    // Getter dan Setter untuk canFly
    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    /**
     * Override metode makeSound() untuk memberikan suara kicauan burung.
     */
    @Override
    public String makeSound() {
        return "Burung ini berkicau.";
    }

    /**
     * Override metode getInfo() untuk menyertakan informasi kemampuan terbang.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + ", Bisa Terbang: " + (canFly ? "Ya" : "Tidak");
    }
}
