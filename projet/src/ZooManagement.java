import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        // ===== Instruction 2 (saisie + validation) =====
        Scanner sc = new Scanner(System.in);

        String zooName;
        do {
            System.out.print("Entrez le nom du zoo : ");
            zooName = sc.nextLine().trim();
        } while (zooName.isEmpty());

        int nbrCages;
        do {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            while (!sc.hasNextInt()) {
                System.out.print("Entier requis : ");
                sc.next();
            }
            nbrCages = sc.nextInt();
        } while (nbrCages <= 0);

        System.out.println(zooName + " comporte " + nbrCages + " cages.");

        // ===== Prosit 3 =====
        Zoo myZoo = new Zoo("Parc Animalier", "Tunis");
        myZoo.displayZoo();

        // --- Instruction 10 : ajout ---
        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal tigre = new Animal("Félidé", "Tigre", 4, true);
        Animal aigle = new Animal("Accipitridé", "Aigle", 3, false);

        System.out.println("Ajout lion  : " + myZoo.addAnimal(lion));
        System.out.println("Ajout tigre : " + myZoo.addAnimal(tigre));
        System.out.println("Ajout aigle : " + myZoo.addAnimal(aigle));

        // --- Instruction 11 : affichage et recherche ---
        myZoo.displayAnimals();
        System.out.println("Recherche lion : " + myZoo.searchAnimal(lion));

        Animal lionCopie = new Animal("Félidé", "Lion", 5, true);
        System.out.println("Recherche copie du lion : " + myZoo.searchAnimal(lionCopie));

        // --- Instruction 12 : unicité ---
        System.out.println("Ajout de la copie du lion (doublon) : " + myZoo.addAnimal(lionCopie));

        // --- Instruction 12 : capacité maximale ---
        for (int i = 1; i <= 25; i++) {
            boolean ok = myZoo.addAnimal(new Animal("Test", "Animal" + i, 1, true));
            if (!ok) {
                System.out.println("Ajout refusé pour Animal" + i + " : zoo plein = " + myZoo.isZooFull());
                break;
            }
        }
        System.out.println(myZoo);

        // --- Instruction 13 : suppression ---
        System.out.println("Suppression du tigre : " + myZoo.removeAnimal(tigre));
        System.out.println("Suppression du tigre (2e fois) : " + myZoo.removeAnimal(tigre));
        myZoo.displayAnimals();

        // --- Instruction 15 : comparaison ---
        Zoo zoo2 = new Zoo("Petit Zoo", "Sfax");
        zoo2.addAnimal(new Animal("Canidé", "Loup", 6, true));

        System.out.println("Zoo 2 plein ? " + zoo2.isZooFull());
        Zoo plusGrand = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("Zoo avec le plus d'animaux : " + plusGrand.name);

        sc.close();
    }
}