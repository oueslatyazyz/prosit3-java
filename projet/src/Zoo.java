public class Zoo {
    // Instruction 14 : nombre de cages constant (= capacité maximale du zoo)
    final int nbrCages = 25;

    Animal[] animals = new Animal[nbrCages];
    int animalCount = 0; // compteur d'animaux réellement présents
    String name;
    String city;

    public Zoo() {}

    // Constructeur paramétré : nbrCages n'est plus passé en paramètre (constante)
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void displayZoo() {
        System.out.println("Zoo : " + name + ", Ville : " + city + ", Cages : " + nbrCages);
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Cages=" + nbrCages
                + ", Animaux=" + animalCount + "]";
    }

    // Instruction 15 : le zoo est-il plein ?
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    // Instruction 10 + 12 : ajout avec contraintes (capacité + unicité)
    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (isZooFull()) {
            return false;                       // capacité maximale atteinte
        }
        if (searchAnimal(animal) != -1) {
            return false;                       // animal déjà présent
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    // Instruction 11 : affichage des animaux
    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo " + name);
            return;
        }
        System.out.println("Animaux du zoo " + name + " (" + animalCount + "/" + nbrCages + ") :");
        for (int i = 0; i < animalCount; i++) {
            System.out.println("  [" + i + "] " + animals[i]);
        }
    }

    // Instruction 11 : recherche par nom, retourne l'indice ou -1
    public int searchAnimal(Animal animal) {
        if (animal == null) {
            return -1;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    // Instruction 13 : suppression avec décalage des éléments
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    // Instruction 15 : retourne le zoo qui contient le plus d'animaux
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }
}