package digitalzoo.com;

/**
 * Mammal adalah subclass yang mewarisi (extends) dari Animal.
 * Class ini merepresentasikan hewan mamalia.
 */
public class Mammal extends Animal {
    // Properti spesifik untuk Mamalia
    private String furColor;

    /**
     * Constructor untuk Mammal.
     * Memanggil constructor parent (Animal) menggunakan super() dan menginisialisasi furColor. [cite: 16]
     * @param name Nama mamalia.
     * @param age Umur mamalia.
     * @param furColor Warna bulu mamalia.
     */
    public Mammal(String name, int age, String furColor) {
        super(name, age); // Memanggil constructor dari class Animal
        this.furColor = furColor;
    }

    // Getter dan Setter untuk furColor
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    /**
     * Override metode makeSound() untuk memberikan suara spesifik mamalia.
     */
    @Override
    public String makeSound() {
        return "Mamalia ini mengeluarkan suara.";
    }

    /**
     * Override metode getInfo() untuk menyertakan informasi warna bulu.
     * Metode ini memanggil getInfo() dari parent untuk mendapatkan nama dan umur.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + ", Warna Bulu: " + furColor;
    }
}
