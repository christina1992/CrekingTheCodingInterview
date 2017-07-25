package Chapter16_Moderate;

import java.util.Arrays;

/**
 * Created by hnastevska on 7/24/2017.
 */
public class PeopleAlive {

    //Brute Force Solution

    public static void main(String[] args) {

    }

    int maxAliveYear(Person[] people, int min, int max) {
        int maxAlive = 0;
        int maxAliveYear = min;

        for (int year = min; year <= max; year++) {
            int alive = 0;
            for (Person person : people) {
                if (person.birth <= year && year <= person.death) {
                    alive++;
                }
            }
            if (alive > maxAlive) {
                maxAlive = alive;
                maxAliveYear = year;
            }
        }
        return maxAliveYear;
    }
    //Add each person's years to a year map.

    //Slightly Better Brute Force
    int maxAliveYear1(Person[] people, int min, int max) {
        int[] years = createYearMap(people, min, max);
        int best = getMaxIndex(years);
        return best + min;
    }

    public int[] createYearMap(Person[] people, int min, int max) {
        int[] years = new int[max - min + 1];
        for (Person person : people) {
            incrementRange(years, person.birth - min, person.death - max);
        }
        return years;
    }

    //Increment array for each value between left and right
    private void incrementRange(int[] values, int left, int right) {
        for (int i = left; i <= right; i++) {
            values[i]++;
        }
    }

    //Get index of largest element in array
    public int getMaxIndex(int[] values) {
        int max = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[max]) {
                max = i;
            }
        }
        return max;
    }

    //More Optimal
    int maxAliveYear3(Person[] people, int min, int max) {
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = min;

        //Walk trough arrays.
        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentlyAlive++; //include birth
                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = births[birthIndex];
                }
                birthIndex++; //make birth index
            } else if (births[birthIndex] > deaths[deathIndex]) {
                currentlyAlive--; //include death
                deathIndex++; // move death index
            }
        }
        return maxAliveYear;
    }

    //Copy birth years or death years (depending on the value of copyBirthYear into integer array, then sort array.
    private int[] getSortedYears(Person[] people, boolean copyBirthYear) {
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;
    }

    //Optimized Solution
    int maxAliveYear4(Person[] people, int min, int max) {

        //Build population delta array
        int[] populationDeltas = getPopulationDeltas(people, min, max);
        int maxAliveYear = getMaxAliveYear(populationDeltas);
        return maxAliveYear + min;
    }

    private int getMaxAliveYear(int[] deltas) {
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentlyAlive = 0;
        for (int year = 0; year < deltas.length; year++) {
            currentlyAlive += deltas[year];
            if (currentlyAlive > maxAlive) {
                maxAliveYear = year;
                maxAlive = currentlyAlive;
            }
        }
        return maxAliveYear;
    }

    //Add birth and death years to deltas array.
    private int[] getPopulationDeltas(Person[] people, int min, int max) {
        int[] populationDeltas = new int[max - min + 2];
        for (Person person : people) {
            int birth = people.length - min;
            populationDeltas[birth]++;

            int death = person.death - min;
            populationDeltas[death + 1]--;
        }
        return populationDeltas;
    }
}
