/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * This file contains a Sanctuary class. 
 * We can access and manipulate the the local variables.
 */
import java.util.HashMap;
import java.util.Set;

/**
 * the Sanctuary class has several methods and a constructor to
 *  access and manipulate the local variables.
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    /**
     * constructor 
     * @param maxAnimals (the max number of animals)
     * @param maxSpecies (the max number of species)
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
        this.sanctuary = new HashMap<String, Integer>();
    }

    /**
     * @param species (the species wanted to get num)
     * @return the number of the species
     */
    public int getNum(String species) {
        if(species == null){
            throw new IllegalArgumentException();
        }
        if(sanctuary.containsKey(species)){
            return sanctuary.get(species);
        }
        else{
            return 0;
        }
    }
    
    /**
     * @return (the number of total animals)
     */
    public int getTotalAnimals() {
        int count = 0;
        Set<String> aniset = sanctuary.keySet();
        for(String animal : aniset){
            count += sanctuary.get(animal);
        }
        return count;
    }
    
    /**
     * @return (the number of total species)
     */
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    /**
     * 
     * @param species (the added species)
     * @param num (the number of the species added)
     * @return (the number of the species are not able to add)
     */
    public int rescue(String species, int num) {
        if(species == null || num <= 0){
            throw new IllegalArgumentException();
        }

        int numRescue;

        if (this.getTotalAnimals() >= this.maxAnimals) {
            return num;
         } // if no any space

        if (num + this.getTotalAnimals() > this.maxAnimals){ // if no enough space 
            numRescue = this.maxAnimals - this.getTotalAnimals();
            if (sanctuary.containsKey(species)) {
                this.sanctuary.replace(species, 
                this.sanctuary.get(species)+numRescue);
                return numRescue;
            }
            else if(getTotalSpecies() + 1 > maxSpecies ){
                return num;
            }
            else{
                sanctuary.put(species, numRescue);
                return num - numRescue;
            }
        }

        if (sanctuary.containsKey(species)){
            this.sanctuary.replace(species, 
            this.sanctuary.get(species) + num);
        }
        else if(getTotalSpecies() +1 > maxSpecies ){
            return num;
        }
        else{
            sanctuary.put(species, num);
        }
        return 0;

    }

    /**
     * @param species (the species will be released)
     * @param num (the number of the species will be released)
     */
    public void release(String species, int num) {
        if(species == null){
            throw new IllegalArgumentException();
        }

        if(num <= 0){
            throw new IllegalArgumentException();
        }

        if (! sanctuary.containsKey(species)) {
            throw new IllegalArgumentException();
        }

        if (num > this.sanctuary.get(species)) {
            throw new IllegalArgumentException();
        }
        
        this.sanctuary.replace(species, 
        this.sanctuary.get(species) - num);
        if (sanctuary.get(species) == 0) {
            this.sanctuary.remove(species);
        }
    

    }
}
