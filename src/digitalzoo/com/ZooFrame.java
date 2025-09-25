package digitalzoo.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * ZooFrame adalah kelas utama untuk GUI aplikasi Digital Zoo Manager.
 * Kelas ini menggunakan JFrame untuk membuat jendela aplikasi.
 */
public class ZooFrame extends JFrame {

    // Penyimpanan data: ArrayList untuk menampung semua objek hewan
    private ArrayList<Animal> zoo = new ArrayList<>();

    // Komponen GUI
    private JTextField nameField, ageField, furColorField;
    private JCheckBox canFlyCheckBox;
    private JComboBox<String> animalTypeComboBox;
    private JButton addButton;
    private JTextArea displayArea;
    private JPanel specificAttributePanel; // Panel untuk input spesifik (warna bulu/bisa terbang)

    public ZooFrame() {
        // Pengaturan dasar untuk window (JFrame)
        setTitle("Digital Zoo Manager");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Layout utama

        // Panggil metode untuk membangun UI
        initComponents();
    }

    private void initComponents() {
        // === Panel Input (Form) di bagian atas (NORTH) ===
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5)); // Grid layout untuk form
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input untuk Nama
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        // Input untuk Umur
        inputPanel.add(new JLabel("Umur:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        // Pilihan Tipe Hewan
        inputPanel.add(new JLabel("Tipe Hewan:"));
        String[] animalTypes = {"Mamalia", "Burung"};
        animalTypeComboBox = new JComboBox<>(animalTypes);
        inputPanel.add(animalTypeComboBox);

        // Panel untuk Atribut Spesifik (akan berubah sesuai pilihan tipe)
        inputPanel.add(new JLabel("Atribut Spesifik:"));
        specificAttributePanel = new JPanel(new CardLayout());

        // Input untuk Warna Bulu (Mamalia)
        JPanel mammalPanel = new JPanel(new BorderLayout());
        furColorField = new JTextField();
        mammalPanel.add(furColorField);

        // Input untuk Bisa Terbang (Burung)
        JPanel birdPanel = new JPanel(new BorderLayout());
        canFlyCheckBox = new JCheckBox("Bisa Terbang?");
        birdPanel.add(canFlyCheckBox);

        specificAttributePanel.add(mammalPanel, "Mamalia");
        specificAttributePanel.add(birdPanel, "Burung");
        inputPanel.add(specificAttributePanel);

        // Tombol "Add Animal"
        addButton = new JButton("Tambah Hewan");
        inputPanel.add(new JLabel()); // Sel kosong untuk alignment
        inputPanel.add(addButton);

        // === Area Tampilan (Log) di bagian tengah (CENTER) ===
        displayArea = new JTextArea();
        displayArea.setEditable(false); // Agar tidak bisa diedit pengguna
        JScrollPane scrollPane = new JScrollPane(displayArea); // Menambahkan scrollbar
        scrollPane.setBorder(BorderFactory.createTitledBorder("Log Kebun Binatang"));

        // Menambahkan panel-panel ke frame utama
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // === Menambahkan Fungsionalitas (Event Listeners) ===

        // Aksi ketika pilihan di ComboBox berubah
        animalTypeComboBox.addActionListener(e -> updateSpecificAttributePanel());

        // Aksi ketika tombol "Tambah Hewan" diklik
        addButton.addActionListener(e -> addAnimal());

        // Inisialisasi tampilan panel atribut spesifik
        updateSpecificAttributePanel();
    }

    private void updateSpecificAttributePanel() {
        CardLayout cl = (CardLayout)(specificAttributePanel.getLayout());
        String selectedType = (String) animalTypeComboBox.getSelectedItem();
        cl.show(specificAttributePanel, selectedType);
    }

    private void addAnimal() {
        try {
            // 1. Baca input dari semua field
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String selectedType = (String) animalTypeComboBox.getSelectedItem();

            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Animal newAnimal = null;

            // 2. Buat objek yang sesuai berdasarkan tipe yang dipilih
            if ("Mamalia".equals(selectedType)) {
                String furColor = furColorField.getText();
                if (furColor.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Warna Bulu tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                newAnimal = new Mammal(name, age, furColor);
            } else if ("Burung".equals(selectedType)) {
                boolean canFly = canFlyCheckBox.isSelected();
                newAnimal = new Bird(name, age, canFly);
            }

            if (newAnimal != null) {
                // 3. Tambahkan objek hewan baru ke ArrayList
                zoo.add(newAnimal);

                // 4. Update JTextArea dengan informasi dan suara hewan baru
                String logMessage = String.format(
                        "Berhasil menambahkan %s baru!\nInfo: %s\nSuara: %s\n-----------------\n",
                        selectedType, newAnimal.getInfo(), newAnimal.makeSound()
                );
                displayArea.append(logMessage);

                // Bersihkan field input
                nameField.setText("");
                ageField.setText("");
                furColorField.setText("");
                canFlyCheckBox.setSelected(false);
            }
        } catch (NumberFormatException ex) {
            // Tangani jika input umur bukan angka
            JOptionPane.showMessageDialog(this, "Umur harus berupa angka!", "Error Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}
